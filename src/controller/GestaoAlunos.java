package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import classes.Aluno;

public class GestaoAlunos {
	
	private int indice = 0;
	private Aluno[] alunos = new Aluno[50];
	private boolean continuar = true;
	
	public void menu() {
		Scanner leitor = new Scanner(System.in);
		
		while(continuar) {
		
			System.out.println("\nEscolha uma das seguintes opções:");
			System.out.println(
					  "\n(C)riar		(E)xibir"
					+ "\n(A)tualizar	(R)emover"
					+ "\n(S)air		(T)odos");
			
			String textoMaiusculo = leitor.nextLine().toUpperCase();
			char letra = textoMaiusculo.charAt(0);
			
			if(letra=='C'){
				criar();
			}else if(letra=='E') {
				exibir();
			}else if(letra=='A') {
				atualizar();
			}else if(letra=='R') {
				excluir();
			}else if(letra=='S') {
				continuar = false;
				System.exit(0);
			}else if(letra=='P') {
				pronto();
			}else if(letra=='T') {
				exibirTodos();
			}
		}
	}
	
	private void pronto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
		this.alunos[this.indice] = new Aluno();
		this.alunos[indice].setAluno(indice, LocalDate.parse("1999-01-30",formatter), "1230", "Eduardo");
		indice++;
		
		this.alunos[this.indice] = new Aluno();
		this.alunos[indice].setAluno(indice, LocalDate.parse("1998-02-15",formatter), "1232", "Jorge");
		indice++;
		
		this.alunos[this.indice] = new Aluno();
		this.alunos[indice].setAluno(indice, LocalDate.parse("1997-03-29",formatter), "1234", "Ana");
		indice++;
		
		this.alunos[this.indice] = new Aluno();
		this.alunos[indice].setAluno(indice, LocalDate.parse("1996-04-25",formatter), "1236", "Fernando");
		indice++;
		
		System.out.println("4 Alunos criados");
		
	}
	
	private void criar() {
		Scanner input = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Aluno aluno = new Aluno();
		
		System.out.println("Criando aluno:");
		aluno.setId(this.indice);
		
		System.out.println("Digite o RA do aluno: ");
		aluno.setRa(input.nextLine());
		
		System.out.println("Digite o nome do aluno: ");
		aluno.setNome(input.nextLine());
		
		System.out.println("Digite a data de nascimento do aluno: ");
		aluno.setNascimento(LocalDate.parse(input.nextLine(),formatter));
		
		
		alunos[indice]=aluno;
		indice++;
		
	}
	
	private void atualizar() {
		Scanner input = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		System.out.println("Editando aluno:");
		
		System.out.println("Digite o RA do aluno: ");
		String ra = input.nextLine();
		
		int indiceEditar = -1;
		
		for(Aluno aluno : this.alunos) {
			if(aluno != null && aluno.getRa().equals(ra)) {
				indiceEditar = (int) aluno.getId();
			}
		}
		if (indiceEditar != -1) {
            
			System.out.println("Digite os novos dados:");			
			System.out.println("Nome atual: "+ this.alunos[indiceEditar].getNome());
			System.out.print("Novo: ");
			this.alunos[indiceEditar].setNome(input.nextLine());
			
			System.out.println("Data de Nascimento atual: "+ this.alunos[indiceEditar].getNascimento());
			System.out.print("Novo: ");
			this.alunos[indiceEditar].setNascimento(LocalDate.parse(input.nextLine(),formatter));
			
			System.out.println("Aluno editado com sucesso");
			
        } else {
            System.out.println("Aluno não encontrado");
        }
	}
	
	private void excluir() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Excluindo aluno:");
		
		System.out.println("Digite o RA do aluno: ");
		String ra = input.nextLine();
		
		int indiceExcluir = -1;
		
		for(Aluno aluno : this.alunos) {
			if(aluno != null && aluno.getRa().equals(ra)) {
				indiceExcluir = (int) aluno.getId();
			}
		}
		if (indiceExcluir != -1) {
            alunos[indiceExcluir] = null;
            System.out.println("Aluno excluído com sucesso");
        } else {
            System.out.println("Aluno não encontrado");
        }
	}
	
	private void exibir() {
		Scanner input = new Scanner(System.in);
		boolean encontrado = false;
		
		System.out.println("Buscando aluno:");
		
		System.out.println("Digite o RA do aluno: ");
		String ra = input.nextLine();
		
		String format = "|%1$-7s|%2$-10s|%3$-10s|%4$-15s|\n";
		System.out.format(format, "ID", "NOME", "RA", "NASC.");
		for(Aluno aluno : this.alunos) {
			if(aluno != null && aluno.getRa().equals(ra)) {
				System.out.println(aluno.toString());
				encontrado = true;
			}
		}
		if(!encontrado) {
			System.out.println("Aluno não encontrado");
		}
	}
	
	private void exibirTodos() {
		
		String format = "|%1$-7s|%2$-10s|%3$-10s|%4$-15s|\n";
		System.out.format(format, "ID", "NOME", "RA", "NASC.");
		
		for(Aluno aluno : this.alunos) {
			if(aluno != null) {
				System.out.print(aluno.toString());
			}
		}
	}
}