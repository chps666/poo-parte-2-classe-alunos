import Escola.Aluno;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //abreviacao da classe scanner
        Scanner sc = new Scanner(System.in);

        //lista de objetos alunos
        ArrayList<Aluno> alunos = new ArrayList<>();

        //variaveis do menu
        int escolha;

    //variaveis auxliares
        //menu 1
        String nome;
        Integer idade;

        //menu 2 & 3
        String escolhaAdcionarNota;
        String AlunoPesquisado;
        String alunoPesquisadoString;
        int idPesquisado;

        do{
            //interface do menu
            System.out.println("=====Cadastrar Aluno=====" +
                                "\n Cadastrar Aluno[1]" +
                                "\n Adcionar Nota[2]" +
                                "\n Media Aluno[3]" +
                                "\n Sair[4]");
            escolha = sc.nextInt();
            sc.nextLine();

            //opcoes do menu
            switch(escolha){
                case 1:
                    //laco de repeticao para garantir que nao entre um valor null na variavel
                    do{
                        System.out.println("==========================" +
                                "Digite o nome completo do aluno: ");
                        nome = sc.nextLine();
                        if(nome.isEmpty()){
                            System.out.println("ERRO: Digite um valor valido!");
                        }
                    }while(nome.isEmpty());

                    //laco de repeticao para garantir que nao entre um valor null na variavel
                    do{
                        System.out.println("Digite a idade do aluno:");
                        idade = sc.nextInt();
                        if(idade == null){
                            System.out.println("ERRO: Digite um valor valido!");
                        }
                    }while(idade == null);

                    /*usando variaveis nome e idade para construtor do aluno, criando e adcionando diretamente na lista
                    de alunos*/
                    alunos.add(new Aluno(nome,idade));

                    break;
                case 2:

                    System.out.println("digite o Nome ou ID do Aluno:");
                    escolhaAdcionarNota = sc.nextLine();

                    //variavel temporaria para auxilio, caso a informacao digitada nao bata com nenhuma da lista de alunos
                    boolean alunoEncontrado = false;

                    //laco de repeticao que percorre todos os objetos alunos da lista um por um
                    for( Aluno a : alunos){

                        //verificacao se a informacao digitada eh apenas numeros
                        if(escolhaAdcionarNota.matches("\\d+")){
                            //transformando em um tipo int e armazenando em uma variavel para melhor manutencao
                            idPesquisado = Integer.parseInt(escolhaAdcionarNota);

                            //verificando se o valor digitado bate com alguma id da lista de alunos
                            if(a.getId() == idPesquisado){
                                System.out.println(a.getNome() + ", " + a.getIdade() + " anos/ ");

                                //caso sim, ativa o metodo de adcionar notas
                                a.Boletim();
                                alunoEncontrado = true;
                                break;
                            }
                        }else{
                            //passando valor de string para variavel com melhor legibilidade do algoritimo a seguir
                            alunoPesquisadoString = escolhaAdcionarNota;

                            //verificando se a informacao bate com algum nome da lista de alunos
                            if(a.getNome().equalsIgnoreCase(alunoPesquisadoString)){
                                System.out.println(a.getNome() + ", " + a.getIdade() + " anos/ ");

                                //caso sim, aciona o metodo de adcionar notas
                                a.Boletim();
                                alunoEncontrado = true;
                                break;
                            }
                        }

                    }
                    if(alunoEncontrado == false){
                        System.out.println("Aluno nao encontrado!");
                    }
                    break;

                    /*o metodo de pesquisa utilizado no menu 3 eh o mesmo do menu 2, a diferenca esta apenas
                na ativacao dos metodos, neste caso o metodo Media*/
                case 3:
                    System.out.println("digite o Nome ou ID do Aluno:");
                    escolhaAdcionarNota = sc.nextLine();

                    for( Aluno a : alunos){
                        if(escolhaAdcionarNota.matches("\\d+")){
                            idPesquisado = Integer.parseInt(escolhaAdcionarNota);
                            if(a.getId() == idPesquisado){
                                System.out.println(a.getNome() + ", " + a.getIdade() + " anos/ ");
                                a.Media();
                                break;
                            }
                        }else{
                            alunoPesquisadoString = escolhaAdcionarNota;
                            if(a.getNome().equalsIgnoreCase(alunoPesquisadoString)){
                                System.out.println(a.getNome() + ", " + a.getIdade() + " anos/ ");
                                a.Media();
                                break;
                            }else{
                                System.out.println("Aluno nao encontrado!");
                            }
                        }

                    }
                    break;
                default:

                    break;
            }
        }while(escolha != 4);

    }
}