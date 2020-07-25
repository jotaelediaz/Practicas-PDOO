/**
 *
 * @author jotaele & joaquinbaca
 */

package GUI;

import napakalaki.Cultist;



public class CultistView extends javax.swing.JPanel {

    Cultist cultistModel;
    
    //Método que define el objeto de tipo Sectario que se mostrará en la vista
    public void setCultist (Cultist c) {
        
        cultistModel = c;
        
        nameL.setText( (cultistModel.getName()));
        
        if (cultistModel.getBasicValue() >= 0) {
            basicL.setText( "+"+Integer.toString(cultistModel.getBasicValue())  );
        }
        
        
        //specialL.setText( Integer.toString(cultistModel.getSpecialValue())  );

        repaint(); //Para que se reimprima el formulario con el sectario.
        
    }
    /**
    
    
    
    
    /**
     * Creates new form CultistView
     */
    public CultistView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameL = new javax.swing.JLabel();
        basicL = new javax.swing.JLabel();
        Cultistinfotext = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(119, 93));
        setMinimumSize(new java.awt.Dimension(119, 93));
        setSize(new java.awt.Dimension(119, 93));
        setLayout(null);

        nameL.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        nameL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameL.setText("Nombre Sectario");
        add(nameL);
        nameL.setBounds(10, 10, 160, 10);

        basicL.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        basicL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        basicL.setText("+0");
        add(basicL);
        basicL.setBounds(10, 30, 20, 10);

        Cultistinfotext.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        Cultistinfotext.setText("por cada sectario en juego ");
        add(Cultistinfotext);
        Cultistinfotext.setBounds(40, 30, 140, 13);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cultistinfotext;
    private javax.swing.JLabel basicL;
    private javax.swing.JLabel nameL;
    // End of variables declaration//GEN-END:variables
}
