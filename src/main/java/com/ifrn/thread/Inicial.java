package com.ifrn.thread;

import com.ifrn.arquivo.Arquivo;


import java.util.ArrayList;


public class Inicial extends Thread {

    private String[] buffer;
    private int contInatividade = 0;

    /**
     * Metodo run()
     *
     * Você deve utiliza-lo para iniciar a thread.
     * O metodo lista os arquivos do diretorio inicial e adiciona no buffer de String[]
     *
     */
    @Override
    public void run() {
        while(true){
            
            //verifica se o diretorio tem algo
            if (Arquivo.listarDiretorio("inicial").length != 0) {
                
                //se tiver adiciona no buffer
                buffer = Arquivo.listarDiretorio("inicial");
                //consome o buffer
                consomeBuffer();
                
                //zera o contador de inatividade
                contInatividade = 0;
                
            }else{
                
                contInatividade++;
                dormir(5000);
                
                if (contInatividade >= 10) {
                    break;
                }
            }
        }


    }

    /**
     * Metodo consomeBuffer()
     *
     * Você deve utiliza-lo para consumir o array de buffer.
     *
     *@return void
     */
    public void consomeBuffer() {
        
        ArrayList<Processando> tp = new ArrayList();
        for (String buffer1 : buffer) {

            //cria uma nova thread e adiciona no arraylist de thread de processos
            tp.add(new Processando(buffer1));

            //recorta o arquivo
            Arquivo.recortarArquivo("inicial/" + buffer1, "processando/" + buffer1);

            //inicia a thread
            tp.get(tp.size() - 1).start();
            
        }

        dormir(5000);

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
