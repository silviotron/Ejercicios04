/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios04;

import java.util.Scanner;

/**
 *
 * @author silvio
 */
public class Ejercicios04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String entradaUsuario;
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        do{
            System.out.println("**************************************************");
            System.out.println("*  1. todas las vocales                          *");
            System.out.println("*  2. palindromo (string)                        *");
            System.out.println("*  3. fecha valida                               *");
            System.out.println("*  4. anagrama                                   *");
            System.out.println("*  5. camelCase                                  *");
            System.out.println("*  6. brakets                                    *");
            System.out.println("*  7. ...                                        *");
            System.out.println("*  8. ...                                        *");
            System.out.println("*  9. ...                                        *");
            System.out.println("* 10. ...                                        *");
            System.out.println("* 11. ...                                        *");
            System.out.println("*  0. Salir                                      *");
            System.out.println("**************************************************");
            entradaUsuario = teclado.nextLine();
            switch(entradaUsuario){
                case "1":
                    ejercicio01();
                    break;
                case "2":
                    ejercicio02();
                    break;
                case "3":
                    ejercicio03();
                    break;
                case "4":
                    ejercicio04();
                    break;
                case "5":
                    ejercicio05();
                    break;
                case "6":
                    ejercicio06();
                    break;
                case "7":
                    ejercicio07();
                    break;
                case "8":
                    ejercicio08();
                    break;
                case "9":
                    ejercicio09();
                    break;
                case "10":
                    ejercicio10();
                    break;
                case "11":
                    ejercicio11();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }while(!entradaUsuario.equals("0"));        
    }
    
    public static void ejercicio01(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce algo");
        String texto = sc.nextLine();
        if(todasVocales(texto)){
            System.out.println("La cadena ‘texto insertado’ contiene todas las vocales");
        }else{
            System.out.println("La cadena ‘texto insertado’ NO contiene todas las vocales");
            
        }
        

        
    }
    public static boolean todasVocales(String texto){
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;
        for(int posicion = 0; posicion < texto.length(); posicion++){
            char actual = texto.charAt(posicion);
            switch(actual){
                case 'a':
                case 'A':
                    a = 1;
                    break;
                case 'e':
                case 'E':
                    e = 1;
                    break;
                case 'i':
                case 'I':
                    i = 1;
                    break;
                case 'o':
                case 'O':
                    o = 1;
                    break;
                case 'u':
                case 'U':
                    u = 1;
                    break;
            }
            if(a + e + i + o + u == 5)
                return true;
        }
        return (a + e + i + o + u == 5);
    }
    
    public static void ejercicio02(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce algo");
        String texto = sc.nextLine();
        if(esPalindromo(texto)){
            System.out.println("Es palindromo");
        }else{
            System.out.println("No es palindromo");            
        }

    }
    public static boolean esPalindromo(String texto){
        String textoReves = "";
        for(int posicion = texto.length() - 1; posicion >= 0 ; posicion--){
            textoReves = "" + textoReves + texto.charAt(posicion);
        }
        return (texto.equals(textoReves));
    }
    
    public static void ejercicio03(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce una fecha");
        String fecha = sc.nextLine();
        if(fechaValida(fecha)){
            System.out.println("La fecha es valida");
        }else{
            System.out.println("La fecha no es valida");
        }
        
    }
    public static boolean fechaValida(String fecha){
        int primeraBarra = -1;    
        int segundaBarra = -1;
        int posicion = 0;
        while(posicion < fecha.length()){
            if((fecha.charAt(posicion) == '/' ) && (primeraBarra == -1)){
            primeraBarra = posicion;
            }
            if((fecha.charAt(posicion) == '/' ) && (primeraBarra != -1)){
            segundaBarra = posicion;
            }
            posicion++;
        }
        if((primeraBarra == -1) || (segundaBarra == -1) ){
            return false;
        }
        int dia = stringToInt(fecha.substring(0,primeraBarra));
        int mes = stringToInt(fecha.substring(primeraBarra + 1, segundaBarra));
        int ano = stringToInt(fecha.substring(segundaBarra + 1, fecha.length()));
        if (ano < 0){
            return false;
        }
        if (mes < 1 || mes > 12){
            return false;
        }
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if(dia < 1 || dia > 31){
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(dia < 1 || dia > 30){
                    return false;
                }
                break;  
            case 2:
                if(esBisiesto(ano) && (dia < 1 || dia > 29)){
                    return false;
                }
                if(!esBisiesto(ano) && (dia < 1 || dia > 28)){
                    return false;
                } 
                break;
            
        }
        
        
        return true;
        
    }
    public static boolean esBisiesto(int ano){
        boolean condicion1 = (ano % 4 == 0) && !(ano % 100 == 0);
        boolean condicion2 = (ano % 400 == 0);
        return(condicion1 || condicion2);
    }
    public static int stringToInt(String texto){
        int resultado = 0;
        for(int posicion = 0; posicion < texto.length(); posicion++){
            switch(texto.charAt(posicion)){
                case '0':
                    resultado = resultado * 10 + 0;
                    break;
                case '1':
                    resultado = resultado * 10 + 1;
                    break;
                case '2':
                    resultado = resultado * 10 + 2;
                    break;
                case '3':
                    resultado = resultado * 10 + 3;
                    break;
                case '4':
                    resultado = resultado * 10 + 4;
                    break;
                case '5':
                    resultado = resultado * 10 + 5;
                    break;
                case '6':
                    resultado = resultado * 10 + 6;
                    break;
                case '7':
                    resultado = resultado * 10 + 7;
                    break;
                case '8':
                    resultado = resultado * 10 + 8;
                    break;
                case '9':
                    resultado = resultado * 10 + 9;
                    break;                    
                default:
                    return -1;
            }
        }       
        return resultado;
    }
    
    public static void ejercicio04(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce la primera palabra:");
        String primera = sc.nextLine();
        System.out.println("introduce la segunda palabra:");
        String segunda = sc.nextLine();
        if(esAnagrama(primera, segunda)){
            System.out.printf("%s es un anagrama de %s\n", primera, segunda);
        }else{
            System.out.printf("%s no es un anagrama de %s\n", primera, segunda);
        }
        
    }
    public static boolean esAnagrama(String primera, String segunda){
        if(primera.length() != segunda.length()){
            return false;
        }
        primera = primera.toLowerCase();
        segunda = segunda.toLowerCase();
        StringBuilder sb = new StringBuilder(primera);
        StringBuilder sb2 = new StringBuilder(segunda);
        for(int f = 0; f < primera.length(); f++){
            if(segunda.contains(Character.toString(primera.charAt(f)))){
                sb.deleteCharAt(0);
                sb2.deleteCharAt(sb2.indexOf(Character.toString(primera.charAt(f))));
                segunda = sb2.toString();
            }else{
                return false;
            }
        }
        String resultado = sb.toString();
        return resultado.equals("");
    }
    
    public static void ejercicio05(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce un texto:");
        String texto = sc.nextLine(); 
        System.out.printf("%s\n", aCamel(texto));
    }
    public static String aCamel(String texto){
    texto = texto.toLowerCase().trim();
    StringBuilder sb = new StringBuilder(texto);
    String mayus;
    for(int f = 0; f < texto.length(); f++){
        if(texto.charAt(0)!= ' '){
            mayus = Character.toString(texto.charAt(0)).toLowerCase();
            sb.replace( 0, 1, mayus);
        }
        if(texto.charAt(f) == ' '){
            mayus = Character.toString(texto.charAt(f + 1)).toUpperCase();
            sb.replace(f + 1, f + 2, mayus);
//poner en maiuscula la siguiente posicion con stringbuilder
        }
    }
    String camel = sb.toString();
    camel = camel.replace(" ", "");
//camel.replace(" ", "") para borrar los espacios
    return camel;
    }
    
    public static void ejercicio06(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce un texto:");
        String texto = sc.nextLine(); 
        if(esBraketBien(texto)){
            System.out.println("Los brakets son correctos.");
        }else{
            System.out.println("Los brakets no son correctos.");
            
        }
    }
    public static boolean esBraketBien(String texto){
        if(!texto.contains("[") && !texto.contains("]")){
            return true;
        }
        if(!texto.contains("[") || !texto.contains("[")){
            return false;        
        }

        for(int p = 0; p < texto.length(); p++){
            if(texto.charAt(p) == '['){
                for(int f = p; f < texto.length(); f++){
                    if(texto.charAt(f) == ']'){
                    StringBuilder sb = new StringBuilder(texto);
                    sb.replace(f, f + 1, " ");
                    texto = sb.toString();
                    break;
                    }
                    if(f == texto.length() - 1){
                        return false;
                    }
                }            
            }else if(texto.charAt(p) == ']'){
                return false;                
            }    
        }                
        return true;
    }
    
    public static void ejercicio07(){
        
    }
    
    public static void ejercicio08(){
        
    }
    
    public static void ejercicio09(){
        
    }
    
    public static void ejercicio10(){
        
    }
    
    public static void ejercicio11(){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce un texto:");
        String texto = sc.nextLine();
        System.out.println("introduce la clave:");
        String clave = sc.nextLine();
        System.out.println(aCifrado(texto, clave));
    }
    public static String aCifrado(String texto, String clave){
        String resultado = texto;
        
        return resultado;
    }
    
}
