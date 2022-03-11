import java.util.*;
import java.io.*;



public class Main{
 public static void main(String args[]) throws Exception{
     
     

     //creacion con todos los participantes del sorteo
   
     ArrayList<String> participantes = new ArrayList<>();
     ArrayList<String> participantesTotales = new ArrayList<>();

     Collections.addAll(participantes,"Emi", "Lobo", "Clau", "Mari", "Santi", "Fran");
     Collections.addAll(participantesTotales,"Emi", "Lobo", "Clau", "Mari", "Santi", "Fran");

     System.out.println("Los participantes del sorteo son: ");
     participantes.forEach(participante -> System.out.println(participante));

     //Se abre el arhivo sorteados.txt y en ausencia de su existencia .createNewFile lo crea sino no hace nada
     File yaSorteados = new File("./sorteados.txt");
     yaSorteados.createNewFile();

     System.out.println();

     //Creamos un scanner para poder leer archivo y lo leemos linea a linea 
     Scanner scanner = new Scanner(yaSorteados);
     while(scanner.hasNextLine()){
        //removemos a los ya sorteados de los participantes del sorteo
        participantes.remove(scanner.nextLine());
     }
     scanner.close();

     //Se revisa si ya fueron o no sorteados todos los participantes, en caso afirmativo 
     //el archivo de los ya sorteados se elimina y se termina la ejecución
     if(participantes.size() == 0){
        Ventana ventana = new Ventana(participantesTotales, participantes, " ");
        System.out.println("SE REINICIA EL SORTEO, TODOS SORTEADOS"); 
        yaSorteados.delete();
        return;
     }

     System.out.println("Participantes por sortear:");
     participantes.forEach(participante -> System.out.println(participante));
     
     //Se ímprime al sorteado y se lo escribe en el archivo de los ya sorteados y se termina la ejecucion
     System.out.println("\nEl sorteado es: ");
     String ganadorSorteo = participantes.get((int) Math.floor(Math.random() * participantes.size()));
     BufferedWriter escritor = new BufferedWriter(new FileWriter(yaSorteados, true));
     escritor.append(ganadorSorteo + "\n");
     escritor.close();
     System.out.println(ganadorSorteo);

     Ventana ventana = new Ventana(participantesTotales, participantes, ganadorSorteo);
     return;
 }
}