import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

/* La clase JFrame encapsula el concepto de una ventana, para implementar una aplicación que muestre una ventana debemos plantear una clase que herede de la clase JFrame */
public class Ventana{

public JFrame f =  new JFrame("Sorteador");
public int crearYAgregarLabel(ArrayList<String> labelsContent, int posY){
        /* Creamos el objeto de la clase JLabel y le pasamos como parámetro al constructor el texto a mostrar.*/
        ArrayList<JLabel> Labels = new ArrayList<>(); 
        labelsContent.forEach(labelContent -> {Labels.add(new JLabel(labelContent));});
        for(int i=0; i<Labels.size(); i++){
            JLabel label = Labels.get(i);
            label.setBounds(10,posY,200,30);
            f.add(label);
            posY = posY + 20;
        }
    
        //Muestro JFrame (lo último para que lo pinte todo correctamanete)
        f.setVisible(true);

        return posY;
}

  /* Definimos un objeto JLabel para la etiqueta. */

  /* En el constructor de la clase llamamos al método heredado de la clase JFrame llamado setLayout y le pasamos como parámetro un valor null, con esto estamos informándole a la clase JFrame que utilizaremos posicionamiento absoluto para los controles visuales dentro del JFrame*/
  public Ventana(ArrayList<String> participantesTotales, ArrayList<String> participantesRestantes, String sorteado) {

    //Layout absoluto
    f.setLayout(new CardLayout());

    //Tamaño de la ventana
    //f.setBounds(10,10,350,90+(participantesTotales.size()+participantesRestantes.size())*40);

    //Título
    f.setTitle("Sorteador");

    //No redimensionable
    f.setResizable(false);

    f.setSize(400,90+(participantesTotales.size()+participantesRestantes.size())*40);
    //Cerrar proceso al cerrar la ventana
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

    


    participantesTotales.add(0, "Los participantes del sorteo son: ");
    int posY = 0;
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
    
    JButton btn = new JButton("Click");
    
    btn.setBounds(50, posY-10 , 95, 30);
    btn.addActionListener(e -> {
        f.dispose();
     });
     f.add(btn);

    
  }
    
}