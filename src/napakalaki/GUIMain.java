/*
    Napakalaki - PDOO
    Desarrolladores: Juan Luis Díaz - Joaquín Baca
*/

package napakalaki;

import Test.GameTester;
import GUI.*;
import java.util.ArrayList;

public class GUIMain {

    private static NapakalakiView napakalakiView = new NapakalakiView();
    private static Napakalaki napakalakiModel = Napakalaki.getInstance();
      
    
    public static void main(String[] args) {
   
      // Capturamos nombres de los jugadores
      ArrayList<String> names = new ArrayList();
      PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
      names = namesCapture.getNames();
      
      
      Dice.createInstance(napakalakiView);
      
      
      napakalakiModel.initGame(names);
      napakalakiView.setNapakalaki(napakalakiModel);
      napakalakiView.showView();
      
      //napakalakiView.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
              
    }
}
