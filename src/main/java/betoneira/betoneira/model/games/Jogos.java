package betoneira.betoneira.model.games;

import betoneira.betoneira.model.Aposta;

public abstract class Jogos {
    private Integer seed;
    private Aposta apostas[];
    private String tipo;

    
    public abstract void iniciarJogo();/*{
        //Implement Method
    }*/
    public abstract void encerrarJogo();/*{
        //Implement Method
    };*/
    //public abstract void sorteia();
    public abstract Integer calcularMultiplicador();
    //public abstract Integer sorteia();
}