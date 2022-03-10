import java.util.ArrayList;

import javax.swing.*;

/* La clase JFrame encapsula el concepto de una ventana, para implementar una aplicación que muestre una ventana debemos plantear una clase que herede de la clase JFrame */
public class Ventana extends JFrame{


public int crearYAgregarLabel(ArrayList<String> labelsContent, int posY){
        /* Creamos el objeto de la clase JLabel y le pasamos como parámetro al constructor el texto a mostrar.*/
        ArrayList<JLabel> Labels = new ArrayList<>(); 
        labelsContent.forEach(labelContent -> {Labels.add(new JLabel(labelContent));});
        for(int i=0; i<Labels.size(); i++){
            JLabel label = Labels.get(i);
            label.setBounds(10,posY,200,30);
            add(label);
            posY = posY + 20;
        }
    
        //Muestro JFrame (lo último para que lo pinte todo correctamanete)
        setVisible(true);

        return posY;
}

  /* Definimos un objeto JLabel para la etiqueta. */

  /* En el constructor de la clase llamamos al método heredado de la clase JFrame llamado setLayout y le pasamos como parámetro un valor null, con esto estamos informándole a la clase JFrame que utilizaremos posicionamiento absoluto para los controles visuales dentro del JFrame*/
  public Ventana(ArrayList<String> participantesTotales, ArrayList<String> participantesRestantes, String sorteado) {

    //Layout absoluto
    setLayout(null);

    //Tamaño de la ventana
    setBounds(10,10,300,450);

    //Título
    setTitle("Sorteador");

    //No redimensionable
    setResizable(false);

    //Cerrar proceso al cerrar la ventana
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    participantesTotales.add(0, "Los participantes del sorteo son: ");
    int posY = 20;
    posY = crearYAgregarLabel(participantesTotales, posY) + 20;
    if(participantesRestantes.size() != 0){
        participantesRestantes.add(0, "Por sortear: ");
        participantesRestantes.add(" ");
        participantesRestantes.add("El sorteado es:");
        participantesRestantes.add(sorteado);
    }
    else{
        participantesRestantes.add(0, "SE REINICIA EL SORTEO");
        participantesRestantes.add(0, "TODOS SORTEADOS");
    }
        
    posY = crearYAgregarLabel(participantesRestantes, posY) + 20;

  }

}