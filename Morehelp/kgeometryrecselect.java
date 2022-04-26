package phase3;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author John Legg
 */
public class kgeometryrecselect extends javax.swing.JFrame {


    public kgeometryrecselect() {
        initComponents();
    }


    private void initComponents() {

        Homebut = new javax.swing.JButton();//creation of button
        title = new javax.swing.JLabel();//creation of label
        whatshape = new javax.swing.JButton();//creation of button
        compareshape = new javax.swing.JButton();//creation of button
        back = new javax.swing.JLabel();//creation of label

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 763));//jframe size
        setResizable(false);
        getContentPane().setLayout(null);

        Homebut.setText("Return to Homepage");// button text
        Homebut.setFont(new java.awt.Font("Impact", 0, 36));//button font
        Homebut.setBackground(new java.awt.Color(139, 139, 139));//bg color
        Homebut.setOpaque(true);//view bg
        Homebut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 121, 126), 10, true));//border setting
        Homebut.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {//open home
                homepagev2 homepagev2 = new homepagev2();
                homepagev2.setVisible(true);
                setVisible(false);//close grade select

            }
        });
        getContentPane().add(Homebut);// adding to jframe
        Homebut.setBounds(180, 90, 630, 60);//placment and size

        title.setFont(new java.awt.Font("Tahoma", 0, 30)); // font of label
        title.setForeground(new java.awt.Color(255, 255, 255));//font color
        title.setBackground(new java.awt.Color(139, 139, 139));//bg color
        title.setOpaque(true);// bg is visible
        title.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 121, 126), 10, true));//border settings
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);//text setting
        title.setText("Recordings On Kindergarten Geometry");//text
        getContentPane().add(title);//add to the jframe
        title.setBounds(150, 180, 700, 60);//label size

        whatshape.setText("What shape is it?");//text
        whatshape.setBackground(new java.awt.Color(139, 139, 139));// bg color
        whatshape.setOpaque(true);// view bg color
        whatshape.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 121, 126), 10, true));//border settings
        whatshape.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/kidergeometry.png")));//button icon
        whatshape.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);//text property
        whatshape.setVerticalTextPosition(javax.swing.SwingConstants.TOP);//text property
        whatshape.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {// open webpage when clicked on
                try {
                    String url = "https://youtu.be/svrkthG2950"; // open this video shapes and identifying them for kindergarteners
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                } catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        getContentPane().add(whatshape);// add to the frame
        whatshape.setBounds(180, 390, 240, 150);//placement and size

        compareshape.setText("This shape or that shape");//button text
        compareshape.setBackground(new java.awt.Color(139, 139, 139));// bg color
        compareshape.setOpaque(true);// view bg color
        compareshape.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(64, 121, 126), 10, true));//border setting
        compareshape.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/kidergeometry2.png")));//button icon
        compareshape.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);//text prop
        compareshape.setVerticalTextPosition(javax.swing.SwingConstants.TOP);//text prop
        compareshape.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {// open video on browser when clicked.
                try {
                    String url = "https://youtu.be/u1Fm1Qg87eE"; // open this video shape comparison for kindergarteners
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                } catch (java.io.IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        getContentPane().add(compareshape);//add to the frame
        compareshape.setBounds(580, 390, 240, 150);//placement and size
        getContentPane().add(back);//add to the frame
        back.setBounds(0, 0, 1020, 760);//placement and size
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/background.jpg")));//label icon used a background image

        pack();// all the buttons and label on to the frame
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kgeometryrecselect().setVisible(true);
            }//run the form
        });
    }


    private javax.swing.JButton Homebut;//variable creation
    private javax.swing.JLabel back;//variable creation
    private javax.swing.JButton compareshape;//variable creation
    private javax.swing.JLabel title;//variable creation
    private javax.swing.JButton whatshape;//variable creation

}
