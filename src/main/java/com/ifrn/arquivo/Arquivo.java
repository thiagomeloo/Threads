package com.ifrn.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Arquivo {
    
    /**
     * Metodo recortarArquivo()
     *
     * Você deve utiliza-lo para recortar um arquivo '.txt' de um local para
     * outro. O metodo recebe o caminho do arquivo inicial e o caminho de
     * destino.
     *
     * @param source caminho onde está localizado o arquivo
     * @param destino caminho onde se localizará o arquivo que foi recortado
     */
    public static boolean recortarArquivo(String source, String destino) {
        
        // copia os dados
        InputStream in;
        // escreve os dados
        OutputStream out;
        try {
            // arquivos que vamos copiar
            File toFile = new File(source);
            // destino para onde vamos mover o arquivo
            File fromFile = new File(destino);
            //verifica se o arquivo existe
            if (!fromFile.exists()) {
                //verifica se a pasta existe
                if (!fromFile.getParentFile().exists()) {
                    //cria a pasta
                    fromFile.getParentFile().mkdir();
                }
                // cria o arquivo
                fromFile.createNewFile();
                in = new FileInputStream(toFile);
                out = new FileOutputStream(fromFile);
                // buffer para transportar os dados
                byte[] buffer = new byte[1024];
                int length;
                // enquanto tiver dados para ler..
                while ((length = in.read(buffer)) > 0) {
                    // escreve no novo arquivo
                    out.write(buffer, 0, length);
                }
                in.close();
                out.close();
                //apaga o arquivo antigo
                toFile.delete();
                return true;
                
            } else {
                
                return false;
                
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    /**
     * Metodo listarDiretorio()
     *
     * Você deve utiliza-lo para listar todo o conteudo de um diretorio. O
     * metodo retorna um array de String com os arquivos em que contem no
     * diretorio.
     *
     * @param dir caminho onde está localizado o arquivo
     */
    public static String[] listarDiretorio(String dir) {
        File file = new File(dir);
        File[] lista = file.listFiles();
        String[] b = new String[lista.length];
        int i = 0;
        for (int j = lista.length; i < j; i++) {
            File arquivo = lista[i];
            b[i] = arquivo.getName();
        }
        return b;
    }
    
    /**
     * Metodo lerArquivo()
     *
     * Você deve utiliza-lo para ler o conteudo de um arquivo '.txt'. O metodo
     * ler o arquivo e retorna um array de char com os caracteres que o arquivo
     * contem
     *
     * @param source caminho onde está localizado o arquivo
     */
    public static char[] lerArquivo(String source){
        
        String resultado = "";
        char[] c = null;
        
        try {
            
            FileReader leitor = new FileReader(source);
            BufferedReader br = new BufferedReader(leitor);
            String s ;
            
            while ((s = br.readLine()) != null) { 
          
                resultado+=s;
                
            }
            
            leitor.close();
            br.close();
            c = resultado.toCharArray();
            
        } catch (IOException x) {
           
            System.out.println("ERRO");
            
        }
        
        return c;
    }
    
}
