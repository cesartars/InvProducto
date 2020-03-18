package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CursoActivity extends AppCompatActivity {


    private RecyclerView recyclerViewCurso;
    private CursoAdaptador cursoAdaptador;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inve_main);


        recyclerViewCurso=(RecyclerView)findViewById(R.id.recycler);
        recyclerViewCurso.setLayoutManager(new LinearLayoutManager(this));

        InvenBD invenBD= new InvenBD(getApplicationContext());


        cursoAdaptador=new CursoAdaptador(invenBD.mostrarCurso());
        recyclerViewCurso.setAdapter(cursoAdaptador);

    }

}
