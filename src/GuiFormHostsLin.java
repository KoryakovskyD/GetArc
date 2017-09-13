import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class GuiFormHostsLin extends JFrame {

    private JTextField inputIP1 = new JTextField("192.168.11.1");
    private JTextField inputIP2 = new JTextField("192.168.11.2");
    private JTextField inputIP3 = new JTextField("");
    private JTextField inputIP4 = new JTextField("");
    private JTextField inputIP5 = new JTextField("");
    private JTextField inputIP6 = new JTextField("");
    private JTextField inputIP7 = new JTextField("");
    private JTextField inputIP8 = new JTextField("");
    private JTextField inputPrib1 = new JTextField("01");
    private JTextField inputPrib2 = new JTextField("08");
    private JTextField inputPrib3 = new JTextField("");
    private JTextField inputPrib4 = new JTextField("");
    private JTextField inputPrib5 = new JTextField("");
    private JTextField inputPrib6 = new JTextField("");
    private JTextField inputPrib7 = new JTextField("");
    private JTextField inputPrib8 = new JTextField("");
    private JTextField inputShare = new JTextField("/home/PROJECTS");

    private JLabel labelIP = new JLabel("IP-адрес 'linux' хоста");
    private JLabel labelPrib = new JLabel("прибор/подсистема");
    private JLabel labelShare = new JLabel("Расшаренный каталог");


    private JButton button = new JButton("Готово");




    public GuiFormHostsLin() {
        super("IP-адреса 'линуксового' HOST-ЭВМ, с которых надо копировать ПО ЦВК");
        this.setBounds(200,200,1100,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));

        container.add(labelIP);
        container.add(labelPrib);


        container.add(inputIP1);
        container.add(inputPrib1);
        container.add(inputIP2);
        container.add(inputPrib2);
        container.add(inputIP3);
        container.add(inputPrib3);
        container.add(inputIP4);
        container.add(inputPrib4);
        container.add(inputIP5);
        container.add(inputPrib5);
        container.add(inputIP6);
        container.add(inputPrib6);
        container.add(inputIP7);
        container.add(inputPrib7);
        container.add(inputIP8);
        container.add(inputPrib8);

        container.add(labelShare);
        container.add(inputShare);

        container.add(button);


        button.addActionListener(new ButtonEventListener());
    }






    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";

            message += inputIP1.getText() + "      " + inputPrib1.getText() + "\n";
            message += inputIP2.getText() + "      " + inputPrib2.getText() + "\n";
            message += inputIP3.getText() + "      " + inputPrib3.getText() + "\n";
            message += inputIP4.getText() + "      " + inputPrib4.getText() + "\n";
            message += inputIP5.getText() + "      " + inputPrib5.getText() + "\n";
            message += inputIP6.getText() + "      " + inputPrib6.getText() + "\n";
            message += inputIP7.getText() + "      " + inputPrib7.getText() + "\n";
            message += inputIP8.getText() + "      " + inputPrib8.getText() + "\n";
            message += "LINShareDir=/home/PROJECTS" + "\n";
            message += "[LIN]" + "\n" + "\n";

            System.out.println(message);

            try (FileWriter writer = new FileWriter("/home/users/kor/GetArc/getarc.cfg",true))
            {
                writer.write(message);
                writer.flush();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }

            setVisible(false);

            //System.exit(0);
            GuiFormHostsWin app5 = new GuiFormHostsWin();
            app5.setVisible(true);
        }
    }

}