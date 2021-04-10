/*******************************************************
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Profesor: Moises Gonzales
* Main.java 
* Autor: Stefano Aragoni 20261, Marco Jurado 20308 
*
********************************************************/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner; 

class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in); //Se crea el scanner para recibir ingresos del usuario 
        System.out.println("--Diccionario Traductor--\n"); 

        System.out.println("Ingresar el nombre del diccionario ingles-espanol-frances .txt ");
        String dic = scanner.nextLine();

        
        File file = new File(dic);
        Scanner scan2 = new Scanner(file);

        Key llave = new Key<String, Words>();
        Comparator compare = new Comparator<String, Words>();

        ArbolBinarioBusqueda treeEn = new ArbolBinarioBusqueda<String, Words>(compare, llave);
        ArbolBinarioBusqueda treeEs = new ArbolBinarioBusqueda<String, Words>(compare, llave);
        ArbolBinarioBusqueda treeFn = new ArbolBinarioBusqueda<String, Words>(compare, llave);

        while (scan2.hasNextLine()){
            String trioWords = (scan2.nextLine()).toLowerCase();
            String[] lineaMod = trioWords.split(",");

            String english = lineaMod[0];
            String spanish = lineaMod[1];
            String french = lineaMod[2];

            Words en = new Words("english",english, spanish, french);
            Words es = new Words("spanish",english, spanish, french);
            Words fn = new Words("french",english, spanish, french);

            treeEn.Insert(english, en);
            treeEs.Insert(spanish, es);
            treeFn.Insert(french, fn);

        }

        System.out.println("Cargando...\n"); 

        System.out.println("\n--Diccionario: InOrder--"); 

        Visit visitar = new Visit<String,Words>();
        treeEn.InOrder(visitar, treeEn._raiz);

        System.out.println("\nCargando traductor...\n"); 

        System.out.println("\n--Traductor: English / Español / Français--"); 
        System.out.println("\nIngresar el nombre del archivo a traducir .txt ");

        String lines = scanner.nextLine();
        lines.toLowerCase();

        System.out.println("\nCual es el idioma original del txt? Seleccione un numero como opcion. \n1. Ingles\n2. Espanol\n3. Frances");
        int idioma = scanner.nextInt();

        System.out.println("\nA que idioma lo quiere traducir? Seleccione un numero como opcion. \n1. Ingles\n2. Espanol\n3. Frances");
        int idioma2 = scanner.nextInt();

        File file3 = new File(lines);
        Scanner scan4 = new Scanner(file3);

        String text = "";

        while (scan4.hasNextLine()){
            String toBeTranslated = (scan4.nextLine()).toLowerCase();
            text = text + " " + toBeTranslated;
        }
        text = text.trim();

        String[] split = text.split(" ");

        String translation = "";

        System.out.println("\n------Traduccion------");

        if(idioma == 1){
            if(idioma2 == 1){
                System.out.println("No hay nada que traducir. Ya estaba en ese idioma.\nResultado: "+text);
            }else if(idioma2 == 2){
                for(int i = 0; i < split.length; i++){
                    Words temp = (Words)treeEn.Find2(split[i], treeEn._raiz);
                    if(temp != null){
                        
                        translation = translation +" "+temp.translate("spanish");
                        
                        
                    }else{
                        if(split[i].equals(".")){
                            translation = translation +".";
                        }else{
                            translation = translation +" *"+split[i]+"*";
                        }
                    }
                }
            }else if(idioma2 == 3){
                for(int i = 0; i < split.length; i++){
                    Words temp = (Words)treeEn.Find2(split[i], treeEn._raiz);
                    if(temp != null){
                        
                        translation = translation +" "+temp.translate("french");
                        
                    }else{
                        if(split[i].equals(".")){
                            translation = translation +".";
                        }else{
                            translation = translation +" *"+split[i]+"*";
                        }
                    }
                }
            }
        }else if(idioma == 2){
            if(idioma2 == 1){
                for(int i = 0; i < split.length; i++){
                    Words temp = (Words)treeEs.Find2(split[i], treeEn._raiz);
                    if(temp != null){
                        
                        translation = translation +" "+temp.translate("english");
                        
                    }else{
                        if(split[i].equals(".")){
                            translation = translation +".";
                        }else{
                            translation = translation +" *"+split[i]+"*";
                        }
                    }
                }
            }else if(idioma2 == 2){
                System.out.println("No hay nada que traducir. Ya estaba en ese idioma.\nResultado: "+text);
            }else if(idioma2 == 3){
                for(int i = 0; i < split.length; i++){
                    Words temp = (Words)treeEs.Find2(split[i], treeEn._raiz);
                    if(temp != null){
                        
                        translation = translation +" "+temp.translate("french");
                        
                    }else{
                        if(split[i].equals(".")){
                            translation = translation +".";
                        }else{
                            translation = translation +" *"+split[i]+"*";
                        }
                    }
                }
            }

        }else if(idioma == 3){
            if(idioma2 == 1){
                for(int i = 0; i < split.length; i++){
                    Words temp = (Words)treeFn.Find2(split[i], treeEn._raiz);
                    if(temp != null){
                        
                        translation = translation +" "+temp.translate("english");
                        
                    }else{
                        if(split[i].equals(".")){
                            translation = translation +".";
                        }else{
                            translation = translation +" *"+split[i]+"*";
                        }
                    }
                }
            }else if(idioma2 == 2){
                for(int i = 0; i < split.length; i++){
                    Words temp = (Words)treeFn.Find2(split[i], treeEn._raiz);
                    if(temp != null){
                        
                        translation = translation +" "+temp.translate("spanish");
                        
                    }else{
                        if(split[i].equals(".")){
                            translation = translation +".";
                        }else{
                            translation = translation +" *"+split[i]+"*";
                        }
                    }
                }
            }else if(idioma2 == 3){
                System.out.println("No hay nada que traducir. Ya estaba en ese idioma.\nResultado: "+text);
            }

        }

        
        System.out.println(translation+"\n\n");

        
    }
}