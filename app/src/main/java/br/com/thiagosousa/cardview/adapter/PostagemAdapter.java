package br.com.thiagosousa.cardview.adapter;

import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.thiagosousa.cardview.model.Postagem;
import br.com.thiagosousa.cardview.R;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.PostagemViewHolder> {

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    @NonNull
    @Override
    public PostagemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PostagemViewHolder(LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_postagem, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostagemViewHolder postagemViewHolder, int i) {

//        Reunindo os dados em um objeto para inserir na atual posicao da lista
        Postagem post = postagens.get(i);

        postagemViewHolder.textView_Titulo.setText(post.getTitulo());
        postagemViewHolder.textView_Hora.setText(post.getHora());
        postagemViewHolder.textView_Descricao.setText(post.getDescricao());
        postagemViewHolder.imageView_Postagem.setImageResource(post.getImagemResource());
    }

    @Override
    public int getItemCount() {
        return postagens == null? 0 : postagens.size();
    }

    class PostagemViewHolder extends RecyclerView.ViewHolder {

        TextView textView_Titulo, textView_Hora, textView_Descricao;
        ImageView imageView_Postagem;
        MaterialButton button_Like, button_Comentar;

        public PostagemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_Titulo = itemView.findViewById(R.id.textview_titulo);
            textView_Descricao = itemView.findViewById(R.id.textview_descricao);
            imageView_Postagem = itemView.findViewById(R.id.imageview_post);
            button_Like = itemView.findViewById(R.id.button_like);
            button_Comentar = itemView.findViewById(R.id.button_comentar);
//            Este atributo sera estatico...
            textView_Hora = itemView.findViewById(R.id.textview_hora_da_postagem);
        }
    }
}
