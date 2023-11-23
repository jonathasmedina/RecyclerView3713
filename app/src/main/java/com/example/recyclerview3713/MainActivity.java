package com.example.recyclerview3713;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MinhaClasseRecyclerAdapter minhaClasseRecyclerAdapter;
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<Usuario> usuarioArrayList = new ArrayList<Usuario>();
    ArrayList<Usuario> usuarioArrayListCopia = new ArrayList<Usuario>();
    int[] imagensUsuarios = {R.drawable.ic_stat_name, R.drawable.ic_stat_name2, R.drawable.ic_stat_name3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView01);
        searchView = findViewById(R.id.searchView_);

        popularArrayList();

        configurarAdapter();

        //efeito visual de snap - exibe parte do elemento que está além do limite da tela
        SnapHelper snapHelper = new LinearSnapHelper(); // ou PagerSnapHelper(); para simular ViewPager - elemento tela toda
        snapHelper.attachToRecyclerView(recyclerView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                usuarioArrayListCopia.addAll(usuarioArrayList);

                usuarioArrayList.clear();

                if (s.isEmpty()) {
                    usuarioArrayList.addAll(usuarioArrayListCopia);
                } else {
                    s = s.toLowerCase();
                    //percorre o array com os dados originais (todos os favoritos)
                    for (Usuario item : usuarioArrayListCopia) {
                        //caso, nos dados originais, exista o termo procurado, popule o array vazio com o item
                        if (item.getNome().toLowerCase().contains(s)) {
                            usuarioArrayList.add(item);
                        }
                    }
                }

                minhaClasseRecyclerAdapter.notifyDataSetChanged();
                return false;
            }
        });



    }

    private void configurarAdapter() {
        minhaClasseRecyclerAdapter =
                new MinhaClasseRecyclerAdapter(usuarioArrayList);

       RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(minhaClasseRecyclerAdapter);

    }

    private void popularArrayList() {
        usuarioArrayList.add(new Usuario("joao", 15, imagensUsuarios[0]));
        usuarioArrayList.add(new Usuario("joao2", 151, imagensUsuarios[1]));
        usuarioArrayList.add(new Usuario("joao3", 152, imagensUsuarios[2]));
        usuarioArrayList.add(new Usuario("joao4", 135, imagensUsuarios[0]));
        usuarioArrayList.add(new Usuario("joao5", 145, imagensUsuarios[1]));
        usuarioArrayList.add(new Usuario("joao6", 145, imagensUsuarios[2]));
        usuarioArrayList.add(new Usuario("joao6", 145, imagensUsuarios[2]));
        usuarioArrayList.add(new Usuario("joao6", 145, imagensUsuarios[2]));
        usuarioArrayList.add(new Usuario("joao6", 145, imagensUsuarios[2]));
        usuarioArrayList.add(new Usuario("joao6", 145, imagensUsuarios[2]));
    }


}