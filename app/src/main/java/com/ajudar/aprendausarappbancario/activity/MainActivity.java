package com.ajudar.aprendausarappbancario.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.ajudar.aprendausarappbancario.adapter.Adapter;
import com.ajudar.aprendausarappbancario.model.Video;
import com.ajudar.aprendausarappbancario.R;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private List<Video> listaVideos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de videos
        this.listarVideos();

        //configurar adapter
        Adapter adapter = new Adapter( listaVideos, getApplicationContext() );

        //configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter );
    }

    public void listarVideos(){

        Video video = new Video("Pagar boleto - Banco Nubank","https://youtu.be/r3PLcaPH19E");
        this.listaVideos.add(video);

        video = new Video("Pagar boleto - Banco Bradesco","https://youtu.be/FzqNHojQoSk");
        this.listaVideos.add(video);

        video = new Video("Pagar boleto - Banco do Brasil","https://youtu.be/i4-hxmrNYi4");
        this.listaVideos.add(video);

        video = new Video("Fazer Transferência - Banco bradesco","https://youtu.be/fhFH_kEMKkI");
        this.listaVideos.add(video);

    }


}
