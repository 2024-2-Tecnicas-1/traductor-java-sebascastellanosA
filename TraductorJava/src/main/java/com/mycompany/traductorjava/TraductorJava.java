package com.mycompany.traductorjava;

import java.util.*;

public class TraductorJava {
    HashMap<Integer, String> numerosEspañol = new HashMap<>();
    HashMap<Integer, String> numerosIngles = new HashMap<>();


    public void tomarNumeros() {
        
        // Diccionario español
        numerosEspañol.put(1, "uno");
        numerosEspañol.put(2, "dos");
        numerosEspañol.put(3, "tres");
        numerosEspañol.put(4, "cuatro");
        numerosEspañol.put(5, "cinco");
        numerosEspañol.put(6, "seis");
        numerosEspañol.put(7, "siete");
        numerosEspañol.put(8, "ocho");
        numerosEspañol.put(9, "nueve");
        numerosEspañol.put(10, "diez");
        numerosEspañol.put(11, "once");
        numerosEspañol.put(12, "doce");
        numerosEspañol.put(13, "trece");
        numerosEspañol.put(14, "catorce");
        numerosEspañol.put(15, "quince");
        numerosEspañol.put(16, "dieciséis");
        numerosEspañol.put(17, "diecisiete");
        numerosEspañol.put(18, "dieciocho");
        numerosEspañol.put(19, "diecinueve");
        numerosEspañol.put(20, "veinte");
        numerosEspañol.put(30, "treinta");
        numerosEspañol.put(40, "cuarenta");
        numerosEspañol.put(50, "cincuenta");
        numerosEspañol.put(60, "sesenta");
        numerosEspañol.put(70, "setenta");
        numerosEspañol.put(80, "ochenta");
        numerosEspañol.put(90, "noventa");
        numerosEspañol.put(100, "cien");
        numerosEspañol.put(200, "docientos");

        // Diccionario en inglés

        numerosIngles.put(1, "one");
        numerosIngles.put(2, "two");
        numerosIngles.put(3, "three");
        numerosIngles.put(4, "four");
        numerosIngles.put(5, "five");
        numerosIngles.put(6, "six");
        numerosIngles.put(7, "seven");
        numerosIngles.put(8, "eight");
        numerosIngles.put(9, "nine");
        numerosIngles.put(10, "ten");
        numerosIngles.put(11, "eleven");
        numerosIngles.put(12, "twelve");
        numerosIngles.put(13, "thirteen");
        numerosIngles.put(14, "fourteen");
        numerosIngles.put(15, "fifteen");
        numerosIngles.put(16, "sixteen");
        numerosIngles.put(17, "seventeen");
        numerosIngles.put(18, "eighteen");
        numerosIngles.put(19, "nineteen");
        numerosIngles.put(20, "twenty");
        numerosIngles.put(30, "thirty");
        numerosIngles.put(40, "forty");
        numerosIngles.put(50, "fifty");
        numerosIngles.put(60, "sixty");
        numerosIngles.put(70, "seventy");
        numerosIngles.put(80, "eighty");
        numerosIngles.put(90, "ninety");
        numerosIngles.put(100, "one hundred");
        numerosIngles.put(200, "two hundred");    
    }

    public String encontrarNumero(int n, int e){
        //TraductorJava traductor = new TraductorJava();
        
        String es, en;

        if(n < 20){
            es =  numerosEspañol.get(n);
            en =  numerosIngles.get(n);
        } else if(n <= 99 && n >= 30) {
            if(n%10 == 0){
                es = numerosEspañol.get(n);
                en = numerosIngles.get(n);
            } else {
                int op = n - (n%10);
                es =  numerosEspañol.get(op) + " y " + numerosEspañol.get(n%10);
                en = numerosIngles.get(op) + " - " + numerosIngles.get(n%10);
            }
        } else if(n >= 20 && n < 30) {
            if(n == 20){
                es =  "veinte";
                en = "twenty";
            } else {
                es =  "veinti"+numerosEspañol.get(n%10);
                en = "twenty - "+numerosIngles.get(n%10);
            }
        } else {
            es =  "cien";
            en = "one hundred";
        }
        if(e == 1){
            return es;
        } else {
            return en;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        TraductorJava traductor = new TraductorJava();

        traductor.tomarNumeros();

        System.out.println("Ingrese el primer numero:");
        int n1 = sc.nextInt();
        System.out.println("Ingrese el segundo numero:");
        int n2 = sc.nextInt();

        int suma = n1+n2;
        
        String p1Es, p2Es, p1En, p2En;
        p1Es = traductor.encontrarNumero(n1, 1);
        p1En = traductor.encontrarNumero(n1, 2);

        p2Es = traductor.encontrarNumero(n2, 1);
        p2En = traductor.encontrarNumero(n2, 2);

        String resEs = "", resEn = "";
        if(suma <= 100){
            resEs = traductor.encontrarNumero(suma, 1);
            resEn = traductor.encontrarNumero(suma, 2);
        } else {
            if(suma < 200){
                String numEs = traductor.encontrarNumero(suma%100, 1);
                String numEn = traductor.encontrarNumero(suma%100, 2);
                
                resEs = "ciento " + numEs;
                resEn = "one hundred " + numEn; 
            } else {
                resEs = "docientos";
                resEn = "two hundred";
            }
        }

        System.out.println("La suma de " + p1Es + " más " + p2Es + " es: " + resEs);
        System.out.println("The sum of " + p1En + " plus " + p2En + " is: " + resEn);

        sc.close();
    }
}
