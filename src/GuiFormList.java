import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiFormList extends JFrame {

    private JTextField inputArcServDirs = new JTextField("CHECK*" +
                                                         "~ARCPD" +
                                                         "~INFO");

    private JLabel labelArcServDirs = new JLabel("Список каталогов, которые будут скопированиы с сервера изделия."
            + "\n" + "Символ ~ перед именем каталога означает," + "\n"
            + "что не нужно генерировать ошибку при его отсутствии");


    private JButton button = new JButton("Далее");




    public GuiFormList() {
        super("Список каталогов для копироания с сервера изделия");
        this.setBounds(200,200,1100,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));

        container.add(labelArcServDirs);
        container.add(inputArcServDirs);


        container.add(button);


        button.addActionListener(new ButtonEventListener());
    }






    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";

            message += "[ArcServDirs]" + "\n";
            message += inputArcServDirs.getText() + "\n";
            message += "[ArcServDirs]" + "\n";


            System.out.println(message);

            //setVisible(false);

            System.exit(0);
           // GuiFormSet app2 = new GuiFormSet();
            //app2.setVisible(true);
        }
    }

}