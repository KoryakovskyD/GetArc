import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class GuiFormIni extends JFrame {


    private JTextField inputcmdCP = new JTextField("sudo rsync -rlpgt --owner --xattrs --whole-file --force --numeric-ids");
    private JTextField inputcmdZIP = new JTextField("sudo zip -9 -r");
    private JTextField inputMaxLogSize = new JTextField("5242880");
    private JTextField inputHostReachInterval = new JTextField("5");


    private JLabel labelcmdCP = new JLabel("Команда копирования заданных каталогов");
    private JLabel labelcmdZIP = new JLabel("Команда архивирования заданных каталогов");
    private JLabel labelMaxLogSize = new JLabel("Максимальный размер основного логфайла");
    private JLabel labelHostReashInterval = new JLabel("Интервал между повторной проверкой доступности хостов(в секундах)");



    private JButton button = new JButton("Готово!");



    public GuiFormIni() {
        super("Настройки архивной копии GetArc");
        this.setBounds(200,200,1100,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));


        container.add(labelcmdCP);
        container.add(inputcmdCP);

        container.add(labelcmdZIP);
        container.add(inputcmdZIP);

        container.add(labelMaxLogSize);
        container.add(inputMaxLogSize);

        container.add(labelHostReashInterval);
        container.add(inputHostReachInterval);


        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }






    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";

            message += "cmdCP=" + "\"" + inputcmdCP.getText() + "\"" + "\n";
            message += "cmdZIP=" + "\"" + inputcmdZIP.getText() + "\"" + "\n";
            message += "MaxLogSize=" + inputMaxLogSize.getText() + "\n";
            message += "HostReachInterval=" + inputHostReachInterval.getText() + "\n";


            System.out.println(message);

            //try (FileWriter writer = new FileWriter("/home/users/kor/GetArc/getarc.ini",false))
            try (FileWriter writer = new FileWriter("getarc.ini",false))
            {
                writer.write(message);
                writer.flush();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }

            //setVisible(false);

            //GuiFormList app3 = new GuiFormList();
            //app3.setVisible(true);

            System.exit(0);
        }
    }

}