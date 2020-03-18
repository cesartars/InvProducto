package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
//import android.support.v7.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {



    EditText edtCodigo, edtProducto, edtDueño;
    Button btnAgregar, btnMostrar, btnBuscar,btnEditar, btnEliminar, btnCaptureCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        edtCodigo = (EditText) findViewById(R.id.edtCodigo);
        edtProducto = (EditText) findViewById(R.id.edtProducto);
        edtDueño = (EditText) findViewById(R.id.edtDueño);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnBuscar= (Button) findViewById((R.id.btnBuscar));
        btnEditar= (Button) findViewById((R.id.btnEditar));
        btnEliminar = (Button) findViewById((R.id.btnEliminar));

        btnCaptureCode = (Button) findViewById((R.id.btnCaptureCode));

        final InvenBD invenBD = new InvenBD(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invenBD.agregarInventario(edtCodigo.getText().toString(), edtProducto.getText().toString(), edtDueño.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mostrarCurso = new Intent(getApplicationContext(), CursoActivity.class);
                startActivity(mostrarCurso);
            }
        });



        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CursoModelo inventario= new CursoModelo();
                invenBD.buscarCurso(inventario,edtCodigo.getText().toString());
                edtProducto.setText(inventario.getProducto());
                edtDueño.setText(inventario.getDueño());

            }
        });
        btnCaptureCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escaner();
            }
        });

    btnEditar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        invenBD.editarInventario(edtCodigo.getText().toString(),edtProducto.getText().toString(),edtDueño.getText().toString());
        Toast.makeText(getApplicationContext(),"SE MODIFICO EXITOSAMENTE",Toast.LENGTH_SHORT).show();

        }
    });


        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                invenBD.eliminarInventario(edtCodigo.getText().toString());
                Toast.makeText(getApplicationContext(),"SE ELIMINO BIEN EL DATO",Toast.LENGTH_SHORT).show();

            }
        });


    }

        public void escaner() {
        IntentIntegrator intent = new IntentIntegrator(this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);

        intent.setPrompt("ESCANEA EL CODIGO");
        intent.setCameraId(0);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "CANCELADO", Toast.LENGTH_LONG).show();
            }else {
                edtCodigo.setText(result.getContents().toString());
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}





