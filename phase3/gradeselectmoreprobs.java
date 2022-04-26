package phase3;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author John Legg
 */
public class gradeselectmoreprobs extends JFrame {


    public gradeselectmoreprobs() { initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    private void initComponents() {

        Homebut = new JButton();//button creation
        title = new JLabel();//label creation
        kindergarden = new JButton();//button creation
        firstgrade = new JButton();//button creation
        secondgrade = new JButton();//button creation
        thirdgrade = new JButton();//button creation
        fourthgrade = new JButton();//button creation
        back = new JLabel();//label creation
        logo = new JLabel();//label creation

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1024, 763));//size of frame setting
        setSize(new Dimension(1024, 763));//size of frame
        getContentPane().setLayout(null);

        Homebut.setText("Return to Homepage");//button text
        Homebut.setFont(new Font("Impact", 0, 36));//font size and style
        Homebut.setBackground(new Color(139, 139, 139));//bg color
        Homebut.setOpaque(true);//view bg color
        Homebut.setBorder(new LineBorder(new Color(64, 121, 126), 10, true));//border settings
        Homebut.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {//open home
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(homepagev2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(homepagev2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(homepagev2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(homepagev2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                homepagev2 homepagev2 = new homepagev2();
                homepagev2.setVisible(true);
                setVisible(false);//close grade select

            }
        });
        getContentPane().add(Homebut);//add to frame
        Homebut.setBounds(310, 50, 410, 60);//placement and size

        title.setFont(new Font("Tahoma", 0, 30)); // font size and style
        title.setForeground(new Color(255, 255, 255));//font color
        title.setBackground(new Color(139, 139, 139));//bg color
        title.setOpaque(true);//view bg color
        title.setBorder(new LineBorder(new Color(64, 121, 126), 10, true));//border settings
        title.setHorizontalAlignment(SwingConstants.CENTER);//text properties
        title.setText("Select a Grade");//text
        getContentPane().add(title);//add to frame
        title.setBounds(260, 150, 500, 60);//placement and size

        kindergarden.setText("Kindergarten");//text
        kindergarden.setFont(new Font("Impact", 0, 16)); // font size and style
        kindergarden.setBackground(new Color(139, 139, 139));//bg color
        kindergarden.setOpaque(true);//view bg color
        kindergarden.setBorder(new LineBorder(new Color(64, 121, 126), 10, true));//border settigns
        kindergarden.setIcon(new ImageIcon(getClass().getResource("Images/kindergarten.png")));//button icon
        kindergarden.setHorizontalTextPosition(SwingConstants.CENTER);//text properties
        kindergarden.setVerticalTextPosition(SwingConstants.TOP);//text properties
        kindergarden.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {//open more problems  kindergarten
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                Moreproblemk moreproblemk = new Moreproblemk();
                moreproblemk.setVisible(true);//open unit select
                setVisible(false);//close grade select

            }
        });
        getContentPane().add(kindergarden);//add to the frame
        kindergarden.setBounds(210, 250, 190, 150);//placement and size

        firstgrade.setText("First Grade");//text
        firstgrade.setFont(new Font("Impact", 0, 16)); // font size and style
        firstgrade.setBackground(new Color(139, 139, 139));//bg color
        firstgrade.setOpaque(true);//view bg color
        firstgrade.setBorder(new LineBorder(new Color(64, 121, 126), 10, true));//border settigns
        firstgrade.setIcon(new ImageIcon(getClass().getResource("Images/1stgrade.png")));//button icon
        firstgrade.setHorizontalTextPosition(SwingConstants.CENTER);//text properties
        firstgrade.setVerticalTextPosition(SwingConstants.TOP);//text properties
        firstgrade.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {//open more problems  grade one
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                Moreproblemone moreproblemone = new Moreproblemone();
                moreproblemone.setVisible(true);//open unit select
                setVisible(false);//close grade select

            }
        });
        getContentPane().add(firstgrade);//add to the frame
        firstgrade.setBounds(420, 250, 190, 150);//placement and size

        secondgrade.setText("Second Grade");//text
        secondgrade.setFont(new Font("Impact", 0, 16)); // font size and style
        secondgrade.setBackground(new Color(139, 139, 139));//bg color
        secondgrade.setOpaque(true);//view bg color
        secondgrade.setBorder(new LineBorder(new Color(64, 121, 126), 10, true));//border settigns
        secondgrade.setIcon(new ImageIcon(getClass().getResource("Images/2ndgrade.png")));//button icon
        secondgrade.setHorizontalTextPosition(SwingConstants.CENTER);//text properties
        secondgrade.setVerticalTextPosition(SwingConstants.TOP);//text properties
        secondgrade.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {//open more problem  second grade
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemtwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemtwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemtwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemtwo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                Moreproblemtwo moreproblemtwo = new Moreproblemtwo();
                moreproblemtwo.setVisible(true);//open unit select
                setVisible(false);//close grade select

            }
        });
        getContentPane().add(secondgrade);//add on to frame
        secondgrade.setBounds(630, 250, 190, 150);//placement and size

        thirdgrade.setText("Third Grade");//text
        thirdgrade.setFont(new Font("Impact", 0, 16)); // font size and style
        thirdgrade.setBackground(new Color(139, 139, 139));//bg color
        thirdgrade.setOpaque(true);//view bg color
        thirdgrade.setBorder(new LineBorder(new Color(64, 121, 126), 10, true));//border settigns
        thirdgrade.setIcon(new ImageIcon(getClass().getResource("Images/3rdgrade.png")));//button icon
        thirdgrade.setHorizontalTextPosition(SwingConstants.CENTER);//text properties
        thirdgrade.setVerticalTextPosition(SwingConstants.TOP);//text properties
        thirdgrade.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {//open more problem third grade
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemthree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemthree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemthree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemthree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                Moreproblemthree moreproblemthree = new Moreproblemthree();
                moreproblemthree.setVisible(true);//open unit select
                setVisible(false);//close grade select

            }
        });
        getContentPane().add(thirdgrade);//add on to the frame
        thirdgrade.setBounds(320, 420, 190, 150);//placement and size

        fourthgrade.setText("Fourth Grade");//text
        fourthgrade.setFont(new Font("Impact", 0, 16)); // font size and style
        fourthgrade.setBackground(new Color(139, 139, 139));//bg color
        fourthgrade.setOpaque(true);//view bg color
        fourthgrade.setBorder(new LineBorder(new Color(64, 121, 126), 10, true));//border settigns
        fourthgrade.setIcon(new ImageIcon(getClass().getResource("Images/4thgrade.png")));//button icon
        fourthgrade.setHorizontalTextPosition(SwingConstants.CENTER);//text properties
        fourthgrade.setVerticalTextPosition(SwingConstants.TOP);//text properties
        fourthgrade.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {//open more problems  fourth grade
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemfour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemfour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemfour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Moreproblemfour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                Moreproblemfour moreproblemfour = new Moreproblemfour();
                moreproblemfour.setVisible(true);//open unit select
                setVisible(false);//close grade select

            }
        });
        getContentPane().add(fourthgrade);//add on to the frame
        fourthgrade.setBounds(530, 420, 190, 150);//placement and size
        getContentPane().add(logo);//add on to the frame
        logo.setBounds(20, 20, 130, 130);//placement and size
        logo.setIcon(new ImageIcon(getClass().getResource("Images/Numbercruncherslogo.png")));//logo icon
        getContentPane().add(back);//add on to the frame
        back.setBounds(0, 0, 1020, 760);//placement and size
        back.setIcon(new ImageIcon(getClass().getResource("Images/background.jpg")));//icon image used as the background for the frame

        pack();
    }

    private void secondgradeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_secondgradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondgradeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gradeselectmoreprobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gradeselectmoreprobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gradeselectmoreprobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gradeselectmoreprobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gradeselectmoreprobs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton Homebut;//variable creation
    private JLabel back;//variable creation
    private JButton firstgrade;//variable creation
    private JButton fourthgrade;//variable creation
    private JButton kindergarden;//variable creation
    private JButton secondgrade;//variable creation
    private JButton thirdgrade;//variable creation
    private JLabel title;//variable creation
    private JLabel logo;//variable creation
    // End of variables declaration//GEN-END:variables
}
