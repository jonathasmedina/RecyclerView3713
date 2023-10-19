package com.example.recyclerview3713;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Usuario> usuarioArrayList = new ArrayList<Usuario>();
    int[] imagensUsuarios = {R.drawable.ic_stat_name};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView01);

        popularArrayList();

        configurarAdapter();

    }

    private void configurarAdapter() {
        MinhaClasseRecyclerAdapter minhaClasseRecyclerAdapter =
                new MinhaClasseRecyclerAdapter(usuarioArrayList);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(minhaClasseRecyclerAdapter);
    }

    private void popularArrayList() {
        usuarioArrayList.add(new Usuario("joao", 15, imagensUsuarios[0]));
        usuarioArrayList.add(new Usuario("joao2", 151, imagensUsuarios[0]));
        usuarioArrayList.add(new Usuario("joao3", 152, imagensUsuarios[0]));
        usuarioArrayList.add(new Usuario("joao4", 135, imagensUsuarios[0]));
        usuarioArrayList.add(new Usuario("joao5", 145, imagensUsuarios[0]));
        usuarioArrayList.add(new Usuario("joao6", 145, imagensUsuarios[0]));
    }
}