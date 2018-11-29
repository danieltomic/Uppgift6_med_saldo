package com.company;




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class UserInterface extends JPanel {

    private JPanel pnlNorth = new JPanel(new BorderLayout());
    private JPanel pnlCenter = new JPanel(new BorderLayout());
    private JPanel pnlSouth = new JPanel();

    private JButton add = new JButton("Add");
    private JButton remove = new JButton("Remove");
    private JButton find = new JButton("Find");

    private JButton oneNew = new JButton("New Account");
    private JButton multipleNew = new JButton("Multiple"); //kanske gör en egen klass till account add
    private JButton print = new JButton("Skriv ut");

    private JTextArea text = new JTextArea("");

    private Font font = new Font("SansSerif", Font.BOLD, 14);

    public UserInterface() {

        setPreferredSize(new Dimension(400, 200));
        setLayout(new BorderLayout(10, 5));

        add(pnlNorth, BorderLayout.NORTH);
        pnlNorth.add(add, BorderLayout.WEST);
        add.setFont(font);
        add.setPreferredSize(new Dimension(120, 40));
        pnlNorth.add(remove, BorderLayout.CENTER);
        remove.setFont(font);
        remove.setPreferredSize(new Dimension(120, 40));
        pnlNorth.add(find, BorderLayout.EAST);
        find.setFont(font);
        find.setPreferredSize(new Dimension(120, 40));

        add(pnlCenter, BorderLayout.CENTER);
        pnlCenter.add(oneNew, BorderLayout.WEST);
        oneNew.setFont(font);
        oneNew.setPreferredSize(new Dimension(120, 40));

        pnlCenter.add(multipleNew, BorderLayout.CENTER);
        multipleNew.setFont(font);
        multipleNew.setPreferredSize(new Dimension(120, 40));

        pnlCenter.add(print, BorderLayout.EAST);
        print.setFont(font);
        print.setPreferredSize(new Dimension(120, 40));

        add(pnlSouth, BorderLayout.SOUTH);
        pnlSouth.add(text);
        text.setPreferredSize(new Dimension(400, 110));

        addListeners();

    }

    private void addListeners() {
        UserInterfaceListener listen = new UserInterfaceListener();
        add.addActionListener(listen);
        remove.addActionListener(listen);
        find.addActionListener(listen);
        oneNew.addActionListener(listen);
        multipleNew.addActionListener(listen);
        print.addActionListener(listen);

    }

    public void start() {
        JFrame frame = new JFrame("UserInterface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new UserInterface(), 0);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public static void main(String[] args) {

        UserInterface app = new UserInterface();
        app.start();
    }

    private class UserInterfaceListener implements ActionListener {
        String name;
        String pNbr;
        String howMany;
        PersonRegister register = new PersonRegister();

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == add) {
                register.addPerson();
                text.setText(register.getStatusText());
            }

            if (e.getSource() == remove) {
                register.removePerson();
                text.setText(register.getStatusText());
            }

            if (e.getSource() == find) {
                register.findPerson();
                text.setText(register.getStatusText());
            }

            if (e.getSource() == oneNew) {
                Person temp = register.findPerson();
                temp.addAccount();
                text.setText(register.getStatusText());
            }


            if (e.getSource() == multipleNew) {
                Person temp = register.findPerson();
                howMany = JOptionPane.showInputDialog("Hur många konton vill du öppna?");
                int h = Integer.parseInt(howMany);
                for (int i = 0; i < h; i++){
                    temp.addAccount();
                }
            }

            if (e.getSource() == print) {
                Person temp = register.findPerson();
                System.out.println(temp.getBankAccounts());
            }

        }

    }


}
