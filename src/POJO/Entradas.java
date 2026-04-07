package POJO;

public class Entradas {
    //validacao de entrada caso nao seja digitado nada
    public String validarEntrada (String entrada) throws Exception{
        if(entrada.isEmpty()){
            throw new Exception("Preencha este campo");
        }else{
            return entrada;
        }

    }
}
