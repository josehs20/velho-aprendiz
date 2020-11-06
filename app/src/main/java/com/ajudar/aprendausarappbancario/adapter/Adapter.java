package com.ajudar.aprendausarappbancario.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ajudar.aprendausarappbancario.model.Video;
import com.ajudar.aprendausarappbancario.R;
import com.ajudar.aprendausarappbancario.activity.VideoFullScreen;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context context;
    private List<Video> listaVideos;

    public Adapter(List<Video> lista, Context context){
        this.listaVideos = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Video video = listaVideos.get(position);

        holder.tituloDoVideo.setText(video.getTipo());
        holder.webView.loadUrl(video.getLink());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, VideoFullScreen.class);
                i.putExtra("link", video.getLink());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaVideos.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        WebView webView;
        TextView tituloDoVideo;
        Button button;

        @SuppressLint("SetJavaScriptEnabled")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            webView = itemView.findViewById(R.id.videoView);
            tituloDoVideo = itemView.findViewById(R.id.textTitulo);
            button = itemView.findViewById(R.id.fullScreen);

            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);


        }
    }
}
