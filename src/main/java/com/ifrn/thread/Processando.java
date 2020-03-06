package com.ifrn.thread;

import com.ifrn.arquivo.Arquivo;


public class Processando extends Thread {
    
    private String nomeArquivo;
    
    private final String caminhoPasta = "processando/";
    
    /**
     * Metodo construtor
     *
     * Você deve utiliza-lo para instanciar um novo objeto. O metodo recebe uma
     * String com o nome do arquivo a ser processado
     *
     * @param nomeArq
     *
     */
    public Processando(String nomeArq){
        nomeArquivo = nomeArq;
    }
    
    /**
     * Metodo run()
     *
     * Você deve utiliza-lo para iniciar a thread. 
     * 
     *
     */
    @Override
    public void run() {
    
        System.out.println(somaResultado(Arquivo.lerArquivo(caminhoPasta+nomeArquivo)));
        
    }
    
    /**
     * Metodo somaResultado()
     *
     * Você deve utiliza-lo para somar o resultado de um arquivo.
     * @param c
     *
     */
    private int somaResultado(char[] c){
        int result = 0;
        for (int i = 0; i < c.length; i++) {
            
            result += Integer.parseInt(String.valueOf(c[i]));
        }
        
        return result;
        
    }
    
    
    
}
