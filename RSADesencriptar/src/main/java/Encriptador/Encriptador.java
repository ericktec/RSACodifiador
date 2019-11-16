/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encriptador;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 * @author Erick
 */

public class Encriptador {
    private BigInteger n;
    private BigInteger e;

    public Encriptador(BigInteger n, BigInteger e) {
        this.n=n;
        this.e=e;
   
    }

    
    public BigInteger[] encriptar(String mensaje){
        
        byte[] ascii=ConvertirAscii(mensaje);
        BigInteger[] caracter = new BigInteger[ascii.length];
        BigInteger[] encriptado = new BigInteger[ascii.length];
        for(int i =0;i<ascii.length;i++){
            caracter[i]=BigInteger.valueOf(ascii[i]);
        }
//        System.out.println("ascii "+ascii.length+" encriptado "+encriptado.length);
//        System.out.println(Arrays.toString(caracter));
        

        //m^e mod n
        //m^e % n = mensaje encriptado
        for(int i =0;i<ascii.length;i++){
            encriptado[i]= caracter[i].modPow(e, n);
        }
        System.out.println(Arrays.toString(encriptado));
        //System.out.println(encriptado[0]);
        return encriptado;
    }
    
    public byte[] ConvertirAscii(String mensaje){
        //Referencia para convertir string a ascii https://javarevisited.blogspot.com/2015/07/how-to-convert-string-or-char-to-ascii-example.html+
        //Viceversa https://www.technicalkeeda.com/java-tutorials/convert-ascii-to-string-conversion-using-java
        byte[] ascii = mensaje.getBytes(StandardCharsets.US_ASCII);
        return ascii;
    }
    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }
    
    
    
    
    
}
