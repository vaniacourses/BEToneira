package betoneira.model;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import betoneira.interfaces.InterfaceSorteio;

public class Loteria extends Conquista.Jogos {
    private Date inicio;
    private Date fim;
    private static Conquista.Loteria loteria;
    private Map<Integer, List<Conquista.Aposta>> bilhetes;//Nao defini ao certo a tipagem, mas deixar como lembrete de (Aposta, numero)
    private InterfaceSorteio sorteio;
    private Integer[] numerosValidos;//Atualizar o diagrama de classes


    public static Conquista.Loteria getCurrentLoteria(){
        if(loteria == null){
            loteria = new Conquista.Loteria();
        }
        return loteria;
    }
    //@Override
    public void iniciarJogo(){
        this.sorteio = new Conquista.SorteioInteiro();
        //Implement Method
    }
    public Integer sorteia(){//Acho que aqui vai virar uma funcao void, levado em conta o padrao GoF Observer (Correcao, fica a mesma coisa, observer ficou em encerrarJogo)
        Integer numero = (Integer) this.sorteio.sorteia(this.numerosValidos[0], this.numerosValidos[-1]);//Colocar aqui o range de numeros ou cores da aposta (Como retorna o ultimo numero?)
        return numero;
    }
    public void addBilhetes(Conquista.Aposta aposta, int numero){//Adicionando observadores aqui
        List<Conquista.Aposta> temp = this.bilhetes.get(numero);
        temp.add(aposta);
        this.bilhetes.put(numero, temp);//Fazer a logica ainda de escolher o numero
        //Implements Method
    }
    public Integer[] getNumerosValidos(){
        return this.numerosValidos;
    }
    public void encerrarJogo(){
        Integer numero = this.sorteia();
        this.bilhetes.forEach((key, value) -> {
            for (Conquista.Aposta apt : value) {
                if(key == numero){//Fazer talvez um tratamento de voltar o multiplicador relativo a cada aposta (desacoplando aposta de Loteria)
                    apt.encerrarAposta(numero);
                }
                else apt.encerrarAposta(numero);
        };});
    }
    public Integer calcularMultiplicador(){
        //Implements Method
        return 1;
    }

}