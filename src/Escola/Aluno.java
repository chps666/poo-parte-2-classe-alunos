package Escola;
import POJO.Entradas;
import java.util.Scanner;

public class Aluno {
    //abreviacao de classes
    Scanner sc = new Scanner(System.in);
    Entradas ent = new Entradas();

    //propriedades do aluno
    protected String nome;
    protected int idade;
    private int id;
    protected double[] notas = new double[4];

    //cadastro estatico para nunca se repetir a id do aluno
    public static int cadastro;

    public Aluno( String nome, int idade) throws Exception {
        this.nome = ent.validarEntrada(nome);
        this.idade = validarIdade(idade);
        cadastro ++;
        id = cadastro;
    }

    //validacao de idade do aluno
    protected int validarIdade(int idade) throws Exception {
        if(idade >= 6 && idade <= 15){
            return idade;
        }else{
            throw new Exception("A idade do aluno e invalida!");
        }
    }

    //adicao de notas a cada vetor de notas do aluno
    public void Boletim(){
        for(int c = 0; c < notas.length; c ++){
            do{
                if(notas[c] > 10 || notas[c] < 0){
                    System.out.println("Digite uma nota valida!");
                }

                System.out.println("Digite a nota do " + (c + 1)+ "o bimestre:");
                notas[c] = sc.nextDouble();

            }while(notas[c] > 10 || notas[c] < 0);
        }
    }

    //calculo  e print da media e print do boletim do ano
    public void Media(){
        int total = 0;
        for(int c = 0; c < notas.length; c ++){
            total += notas[c];
        }

        System.out.println("1o BIM. || 2o BIM. || 3o BIM. || 4o BIM." +
                "\n" + notas[0] + " || " + notas[1] + " || " + notas[2] + " || " + notas[3] + "");

        System.out.println("Media: " + (total / notas.length));
    }

    //POJO
    public int getIdade() {
        return idade;
    }
    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getNota(int index) {
        return notas[index];
    }

    public void setNota(double nota, int index) {
        this.notas[index] = nota;
    }
}
