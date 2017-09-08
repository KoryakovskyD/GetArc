import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class GuiFormHosts extends JFrame {

    private JTextField inputIP1 = new JTextField("192.168.11.1");
    private JTextField inputIP2 = new JTextField("192.168.11.2");
    private JTextField inputPrib1 = new JTextField("01");
    private JTextField inputPrib2 = new JTextField("08");
    private JTextField inputShare = new JTextField("/home/PROJECTS");
    private JTextField inputOS = new JTextField("LIN");


    private JLabel labelIP = new JLabel("IP-адрес");
    private JLabel labelPrib = new JLabel("прибор/подсистема");
    private JLabel labelShare = new JLabel("Расшаренный каталог");
    private JLabel labelOS = new JLabel("Тип операционной системы");


    private JButton button = new JButton("Готово");




    public GuiFormHosts() {
        super("IP-адреса HOST-ЭВМ, с которых надо копировать ПО ЦВК");
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

        container.add(labelShare);
        container.add(inputShare);

        container.add(labelOS);
        container.add(inputOS);

        container.add(button);


        button.addActionListener(new ButtonEventListener());
    }






    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";

            message += "[" + inputOS.getText() + "]" + "\n";
            message += inputIP1.getText() + "      " + inputPrib1.getText() + "\n";
            message += inputIP2.getText() + "      " + inputPrib2.getText() + "\n";
            message += inputOS.getText() + "ShareDir=" + inputShare.getText() + "\n";
            message += "[" + inputOS.getText() + "]" + "\n" + "\n";


            System.out.println(message);

            try (FileWriter writer = new FileWriter("C:\\USR\\aa.txt",true))
            {
                writer.write(message);
                writer.flush();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }

            //setVisible(false);

            System.exit(0);
            // GuiFormSet app2 = new GuiFormSet();
            //app2.setVisible(true);
        }
    }

}