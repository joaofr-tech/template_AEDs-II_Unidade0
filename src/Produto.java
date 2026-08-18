import java.text.NumberFormat;

public abstract class Produto {
	
	private static final double MARGEM_PADRAO = 0.2;
	protected String descricao;
	protected double precoCusto;
	protected double margemLucro;
	
	private void init(String desc, double precoCusto, double margemLucro) {
		
		if ((desc.length() >= 3) && (precoCusto > 0.0) && (margemLucro > 0.0)) {
			descricao = desc;
			this.precoCusto = precoCusto;
			this.margemLucro = margemLucro;
		} else {
			throw new IllegalArgumentException("Valores inválidos para os dados do produto.");
		}
	}
	
	protected Produto(String desc, double precoCusto, double margemLucro) {
		init(desc, precoCusto, margemLucro);
	}
	
	protected Produto(String desc, double precoCusto) {
		init(desc, precoCusto, MARGEM_PADRAO);
	}
	
	public abstract double valorDeVenda();
	
    @Override
	public String toString() {
    	
    	NumberFormat moeda = NumberFormat.getCurrencyInstance();
    	
    	return String.format("NOME: " + descricao + ": " + moeda.format(valorDeVenda()));
	}
    
    @Override
    public boolean equals(Object obj) {

		if (!(obj instanceof Produto)){
			return false;
		}

		Produto p2 = (Produto) obj;
		return this.descricao.equalsIgnoreCase(p2.descricao);
    }
    
    static Produto criarDoTexto(String linha) {
    	return null;
    }
    	
    public abstract String gerarDadosTexto();
}