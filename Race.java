/**
 * Race class
 * Class Race maakt gebruik van de class Paard
 *
 * @author Martijn van der Bruggen
 * @version alpha - aanroep van cruciale methodes ontbreekt
 * (c) 2009 Hogeschool van Arnhem en Nijmegen
 *
 * Note: deze code is bewust niet op alle punten generiek
 * dit om nog onbekende constructies te vermijden.
 *
 * Updates
 * 2010: verduidelijking van opdrachten in de code MvdB
 * 2011: verbetering leesbaarheid code MvdB
 * 2012: verbetering layout code en aanpassing commentaar MvdB
 * 2013: commentaar aangepast aan nieuwe opdracht MvdB
 *
 *************************************************
 * Afvinkopdracht: werken met methodes en objecten
 *************************************************
 * Opdrachten zitten verwerkt in de code
 * 1) Declaratie constante
 * 2) Declaratie van Paard (niet instantiering)
 * 3) Declareer een button
 * 4) Zet breedte en hoogte van het frame
 * 5) Teken een finish streep
 * 6) Creatie van 4 paarden
 * 7) Pauzeer
 * 8) Teken 4 paarden
 * 9) Plaats tekst op de button
 * 10) Start de race, methode aanroep
 *
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.Scanner;
import javax.swing.*;

public class Race extends JFrame implements ActionListener {

    /** declaratie van variabelen */
    static int lengte = 250; // (1) Declareer hier een constante int met de naam lengte en een waarde van 250 */
    private Paard h1, h2, h3, h4, h5;    // (2) Declareer hier h1, h2, h3, h4 van het type Paard
                            //  Deze paarden instantieer je later in het programma
    private JButton button; //(3) Declareer een button met de naam button van het type JButton
    private JPanel panel;
    private JLabel label1;

    /** Applicatie - main functie voor runnen applicatie */
    public static void main(String[] args) {
        Race frame = new Race();
        frame.setSize(420,250);/* (4) Geef het frame een breedte van 400 en hoogte van 150 */
        frame.createGUI();
        frame.setVisible(true);
    }

    /** Loop de race
     */
    private void startRace(Graphics g) {
        panel.setBackground(Color.white);
        /**(6) Creatie van 4 paarden
         * Dit is een instantiering van de 4 paard objecten
         * Bij de instantiering geef je de paarden een naam en een kleur mee
         * Kijk in de class Paard hoe je de paarden
         * kunt initialiseren. **/

        h1 = new Paard("Toska", Color.black);
        h2 = new Paard("Moonshine",Color.cyan);
        h3 = new Paard("Amerigo", Color.pink);
        h4 = new Paard("Vlekje",Color.gray);
        h5 = new Paard("Bonnie", Color.green);
        /** Loop tot een paard over de finish is*/
        while (h1.getAfstand() < lengte
                && h2.getAfstand() < lengte
                && h3.getAfstand() < lengte
                && h4.getAfstand() < lengte
                && h5.getAfstand() < lengte) {
            h1.run();
            h2.run();
            h3.run();
            h4.run();
            h5.run();

            /* (7) Voeg hier een aanroep van de methode pauzeer toe zodanig
             * dat er 1 seconde pauze is. De methode pauzeer is onderdeel
             * van deze class
             */
            /* (8) Voeg hier code in om 4 paarden te tekenen die rennen
             * Dus een call van de methode tekenPaard
             */
            pauzeer(100);
            g.setColor(Color.white);
            g.fillRect(0,0,300,200);
            g.setColor(Color.red);/* (5) Geef de finish streep een rode kleur */
            g.fillRect(lengte+35, 0, 3, 200);
            tekenPaard(g,h1);
            tekenPaard(g,h2);
            tekenPaard(g,h3);
            tekenPaard(g,h4);
            tekenPaard(g,h5);
        }
        /** Kijk welk paard gewonnen heeft
         */
        if (h1.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h1.getNaam() + " gewonnen!");
        }
        if (h2.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h2.getNaam() + " gewonnen!");
        }
        if (h3.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h3.getNaam() + " gewonnen!");
        }
        if (h4.getAfstand() > lengte) {
            JOptionPane.showMessageDialog(null, h4.getNaam() + " gewonnen!");
        }
        if (h5.getAfstand() > lengte) {
        JOptionPane.showMessageDialog(null, h5.getNaam() + " gewonnen!");
        }
    }

    /** Creatie van de GUI*/
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(320, 200));
        panel.setBackground(Color.white);
        window.add(panel);
        button = new JButton("Run!");
        /* (9) Zet hier de tekst Run! op de button */
        window.add(button);
        button.addActionListener(this);
    }

    /** Teken het paard */
    private void tekenPaard(Graphics g, Paard h) {

        Image image = Toolkit.getDefaultToolkit().getImage("./horse.jpg");
        g.drawImage(image,h.getAfstand(),30*h.getPaardNummer(),this);

        //g.setColor(h.getKleur());
        //g.fillRect(10, 20 * h.getPaardNummer(), h.getAfstand(), 5);
    }

    /** Actie indien de button geklikt is*/
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        /* (10) Roep hier de methode startrace aan met de juiste parameterisering */
        startRace(paper);
    }

    /** Pauzeer gedurende x millisecondes*/
    public void pauzeer(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            System.out.println("Pauze interruptie");
        }
    }


}

