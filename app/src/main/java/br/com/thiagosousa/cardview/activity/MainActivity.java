package br.com.thiagosousa.cardview.activity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.thiagosousa.cardview.R;
import br.com.thiagosousa.cardview.adapter.PostagemAdapter;
import br.com.thiagosousa.cardview.model.Postagem;

public class MainActivity extends AppCompatActivity {

    //    Views
    private RecyclerView recyclerPostagens;
    private List<Postagem> postagens = this.gerarPostagens();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Conectando o recyclerview da classe com o do xml
        recyclerPostagens = findViewById(R.id.recyclerPostagem);

        this.configurarRecyclerView();
    }

    /**Configuura o recycleview antes de exibir
     * Tal como adapter e o layoutmanager que sera utilizado**/
    private void configurarRecyclerView() {

//        Configurando o layoutManager para o recyclerPostagens
        this.configLayoutManager(recyclerPostagens);

    //        Configurando o adapter para o recyclerPostagens
    PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagens.setAdapter(adapter);
}

/**Muda o LayoutManager do recycler view de acordo com a orienacao do dispositivo
 * Caso a orientação seja Portrait (Aparelho em pe), a visualizacao sera de um item por linha abaixo do outro
 * Caso a orientacao seja Landscape, a visualizacao sera de dois itens por linha um ao lado do outro
 * **/
    private void configLayoutManager(RecyclerView target) {
        //        Sera usado para pegar a orientacao atual da tela do dispositivo
        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

//            Caso a orientacao da tela seja normal (aparelho em pe)
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            target.setLayoutManager(layoutManager);

        } else if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

//            Caso o aparelho esteja posicionado na horizontal (deitado)
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
//            ((GridLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
            target.setLayoutManager(layoutManager);
        }
    }

    /**Gera algumas postagens representatvas para exibir no recyclerview**/
    private List<Postagem> gerarPostagens() {
        List<Postagem> postagens = new ArrayList<>();

        postagens.add(new Postagem(
                "Thiago Silva",
                "agora mesmo",
                "Viagem pelo #Canadá",
                R.drawable.imagem1));

        postagens.add(new Postagem(
                "Mariana Shiterz",
                "ontem",
                "Hoje New York amanheceu assim :)",
                R.drawable.imagem2));

        postagens.add(new Postagem(
                "Bernardo siqueira",
                "a 3 horas",
                "Me despedindo desse lugar incrível!",
                R.drawable.imagem3));

        postagens.add(new Postagem(
                "Amanda Oliveira",
                "No fim de semana",
                "Mais que vista!!!",
                R.drawable.imagem4));

        return postagens;
    }

}
