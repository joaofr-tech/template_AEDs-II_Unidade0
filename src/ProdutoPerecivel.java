import java.text.NumberFormat;
import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;

public class ProdutoPerecivel extends Produto{

    private static final double DESCONTO = 0.25;
    private static final int PRAZO_DESCONTO = 7;
    private LocalDateTime dataDeValidade;


    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDateTime dataDeValidade){
        super(desc, precoCusto, margemLucro);
        setDataDeValidade(dataDeValidade);
    }

    public void setDataDeValidade(LocalDateTime dataDeValidade){
        if (dataDeValidade.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("essa data nao poh");
        }
        this.dataDeValidade = dataDeValidade;
    }

    @Override
    public double valorDeVenda(){

        if (dataDeValidade.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Produto fora da validade.");
        }

       if (dataDeValidade.isAfter(LocalDateTime.now().plusDays(PRAZO_DESCONTO))){
           return super.valorDeVenda() * (1 - DESCONTO);
       }
        return super.valorDeVenda();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
