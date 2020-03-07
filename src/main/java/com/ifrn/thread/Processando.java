package com.ifrn.thread;

import com.ifrn.arquivo.Arquivo;



public class Processando extends Thread {
    
    private String nomeArquivo;
    
    
    private final String caminhoPasta = "processando/";
    private final String caminhoPastaDestino = "final/";
    
    private final String arquivoResultado = "RESULTADO.txt";
    
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
    
        while(true){
            try {
                dormir(5000);
                int resultadoSoma = somaResultado(Arquivo.lerArquivo(caminhoPasta+nomeArquivo));
                if(Arquivo.escreverNoArquivo(caminhoPasta+arquivoResultado, nomeArquivo+": "+resultadoSoma)){
                    Arquivo.recortarArquivo(caminhoPasta+nomeArquivo,caminhoPastaDestino+nomeArquivo);
                }
                break;
            } catch (Exception e) {
                dormir(5000);
            }
        }
        
        
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
    
    /**
     * Metodo dormir()
     *
     * Você deve utiliza-lo para dar um sleep do tempo passsado no @param.
     *
     * @param tempo
     * @return void
     *
     */
    private void dormir(int tempo){
        try {
            this.sleep(tempo);
        } catch (InterruptedException ex) {
            System.out.println("Erro de interrupção");
        }
    }
    
}
