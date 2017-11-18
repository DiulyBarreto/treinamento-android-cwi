package br.com.cwi.aula2.RecyclerView;

/**
 * Created by letscode on 18/11/2017.
 */

public class Menu {

    private String nome;
    private int idImage;

    public Menu(String nome, int idImage) {
        this.nome = nome;
        this.idImage = idImage;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdImage() {
        return this.idImage;
    }
}
