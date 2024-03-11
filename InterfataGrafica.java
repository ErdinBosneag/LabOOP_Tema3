import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InterfataGrafica extends JFrame {
    private ListaDeComparable <Student> lista= new ListaDeComparable<>(6, Student.class);
    private JButton bAdaugareElement = new JButton("Adaugare Element");
    private JButton bStergereElement = new JButton("Stergere Element");
    private JButton bSortareElement = new JButton("Sortare Element");
    private JLabel nume = new JLabel("Nume: ");
    private JLabel prenume = new JLabel("Prenume: ");
    private JLabel prezente = new JLabel("Prezente: ");
    private JTextField tNume = new JTextField("",10);
    private JTextField tPrenume = new JTextField("",10);
    private JTextField tPrezente = new JTextField("",10);
    private JLabel continut = new JLabel("Continut lista:");
    private JTextArea continutLista = new JTextArea("",30,15);
    private JLabel cazExtrem = new JLabel("Caz extrem: ");
    private JTextArea tCazExtrem = new JTextArea("",10,15);

    int ultimaValoareProcesata = 0;
    class Adaugare implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student x = new Student(Integer.parseInt(tPrezente.getText()), tNume.getText(), tPrenume.getText());
            try {
                tCazExtrem.setText("");
                lista.adaugareElement(x);
            } catch (ExceptieListaPlina ex) {
                tCazExtrem.setText("Lista este plina");
            }
            continutLista.setText(lista.afisareElemente());
        }
    }
    class Stergere implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tCazExtrem.setText("");
                lista.eliminareElement();
            } catch (ExceptieListaGoala ex) {
                tCazExtrem.setText(("Lista este goala"));
            }
            continutLista.setText(lista.afisareElemente());
        }

    }

    class Sortare implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            lista.sortareElemente();
            continutLista.setText(lista.afisareElemente());
        }

    }

    private Adaugare buttonAdaugare = new Adaugare();
    private Stergere buttonStergere = new Stergere();
    private Sortare buttonSortare = new Sortare();
    public InterfataGrafica () {
        bAdaugareElement.addActionListener(buttonAdaugare);

        bStergereElement.addActionListener(buttonStergere);

        bSortareElement.addActionListener(buttonSortare);

        Box bNume = Box.createHorizontalBox();
        bNume.add(nume); bNume.add(Box.createHorizontalStrut(22));
        bNume.add(tNume); bNume.add(Box.createHorizontalStrut(3));
        bNume.add(Box.createHorizontalGlue());

        Box bPrenume = Box.createHorizontalBox();
        bPrenume.add(prenume); bPrenume.add(Box.createHorizontalStrut(3));
        bPrenume.add(tPrenume); bPrenume.add(Box.createHorizontalStrut(3));
        bPrenume.add(Box.createHorizontalGlue());

        Box bPrezente = Box.createHorizontalBox();
        bPrezente.add(prezente); bPrezente.add(Box.createHorizontalStrut(3));
        bPrezente.add(tPrezente); bPrezente.add(Box.createHorizontalStrut(3));
        bPrezente.add(Box.createHorizontalGlue());

        Box bContinut = Box.createHorizontalBox();
        bContinut.add(continut); bContinut.add(Box.createHorizontalStrut(3));
        bContinut.add(continutLista); bContinut.add(Box.createHorizontalStrut(3));
        bContinut.add(Box.createHorizontalGlue());

        Box bCazExtrem = Box.createHorizontalBox();
        bCazExtrem.add(cazExtrem); bCazExtrem.add(Box.createHorizontalStrut(11));
        bCazExtrem.add(tCazExtrem); bCazExtrem.add(Box.createHorizontalStrut(3));
        bCazExtrem.add(Box.createHorizontalGlue());

        Box bh2 = Box.createHorizontalBox();

        Box bv1 = Box.createVerticalBox(); bv1.add(Box.createVerticalStrut(12));
        bv1.add(bNume); bv1.add(Box.createVerticalStrut(12));
        bv1.add(bPrenume); bv1.add(Box.createVerticalStrut(12));
        bv1.add(bPrezente); bv1.add(Box.createVerticalStrut(12));
        bv1.add(bContinut); bv1.add(Box.createHorizontalStrut(20));
        bv1.add(bCazExtrem); bv1.add(Box.createHorizontalStrut(10));
        bv1.add(Box.createVerticalGlue());

        Box bv2 = Box.createVerticalBox(); bv2.add(Box.createVerticalStrut(12));
        bv2.add(bAdaugareElement); bv2.add(Box.createVerticalStrut(10));
        bv2.add(bStergereElement); bv2.add(Box.createVerticalStrut(10));
        bv2.add(bSortareElement); bv2.add(Box.createVerticalStrut(10));
        bv2.add(Box.createVerticalGlue());

        Box bh3 = Box.createHorizontalBox(); bh3.add(Box.createHorizontalStrut(10));
        bh3.add(bv1); bh3.add(Box.createHorizontalStrut(10));
        bh3.add(bv2); bh3.add(Box.createHorizontalStrut(10));
        bh3.add(Box.createHorizontalGlue());
        Container cp = getContentPane();
        cp.add(BorderLayout.CENTER, bh3);

    }
    public static void main(String[] args) {
        InterfataGrafica ig = new InterfataGrafica ();
        ig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ig.setSize(700, 320);
        ig.setLocationRelativeTo(null);
        ig.setVisible(true);
        ig.setResizable(false);
    }
}