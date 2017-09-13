import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class GuiFormHostsWin extends JFrame {

    private JTextField inputIP1 = new JTextField("");
    private JTextField inputIP2 = new JTextField("");
    private JTextField inputPrib1 = new JTextField("");
    private JTextField inputPrib2 = new JTextField("");
    private JTextField inputIP3 = new JTextField("");
    private JTextField inputIP4 = new JTextField("");
    private JTextField inputPrib3 = new JTextField("");
    private JTextField inputPrib4 = new JTextField("");
    private JTextField inputShare = new JTextField("/home/PROJECTS");


    private JLabel labelIP = new JLabel("IP-адрес 'Windows' хоста");
    private JLabel labelPrib = new JLabel("прибор/подсистема");
    private JLabel labelShare = new JLabel("Расшаренный каталог");


    private JButton button = new JButton("Далее");




    public GuiFormHostsWin() {
        super("IP-адреса 'виндового' HOST-ЭВМ, с которых надо копировать ПО ЦВК");
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

        container.add(labelShare);
        container.add(inputShare);

        container.add(button);


        button.addActionListener(new ButtonEventListener());
    }






    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";

            message += "[WIN]" + "\n";
            message += inputIP1.getText() + "       " + inputPrib1.getText() + "\n";
            message += inputIP2.getText() + "      " + inputPrib2.getText() + "\n";
            message += inputIP3.getText() + "       " + inputPrib3.getText() + "\n";
            message += inputIP4.getText() + "      " + inputPrib4.getText() + "\n";
            message += "WINShareDir=/home/PROJECTS" + "\n";
            message += "[WIN]" + "\n" + "\n";


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
            GuiFormIni app6 = new GuiFormIni();
            app6.setVisible(true);
        }
    }

}