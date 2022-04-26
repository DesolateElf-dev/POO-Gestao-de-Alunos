package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
	
	private long id;
	private LocalDate nascimento;
	private String ra;
	private String nome;
	
	public void setAluno(long id, LocalDate nascimento, String ra, String nome) {
		this.id = id;
		this.nascimento = nascimento;
		this.ra = ra;
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		
		DateTimeFormatter dataNascimento = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String text = this.nascimento.format(dataNascimento);
		
		String dadosAluno[] = {Long.toString(this.id),this.nome, this.ra, text};
		
		String format = "|%1$-7s|%2$-10s|%3$-10s|%4$-15s|\n";
		//System.out.format(format, "ID", "NOME", "RA", "NASC.");
		return String.format(format, (Object[]) dadosAluno);
	}

}