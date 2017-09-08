import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class GuiFormList extends JFrame {

    private JTextArea inputArcServDirs = new JTextArea("CHECK*" + "\n" +
                                                         "~ARCPD" + "\n" +
                                                         "~INFO"  + "\n" +
                                                         "SRC/COMMON_MNT" + "\n" +
                                                         "SRC/RIO" + "\n" +
                                                         "~SRC/INTEL" + "\n" +
                                                         "FLASH/RIO" + "\n" +
                                                         "FLASH/COMMON_MNT");


    private JLabel labelArcServDirs = new JLabel("<html>Список каталогов, которые будут скопированиы с сервера изделия."
            + "<br>" + "Символ ~ перед именем каталога означает," + "<br>"
            + "что не нужно генерировать ошибку при его отсутствии</html>");


    private JButton button = new JButton("Далее");




    public GuiFormList() {
        super("Список каталогов для копироания с сервера изделия");
        this.setBounds(200,200,1100,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));

        container.add(labelArcServDirs);
        container.add(inputArcServDirs);
        inputArcServDirs.setFont(new Font("Dialog", Font.PLAIN, 16));


        container.add(button);


        button.addActionListener(new ButtonEventListener());
    }






    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";

            message += "[ArcServDirs]" + "\n";
            message += inputArcServDirs.getText() + "\n";
            message += "[ArcServDirs]" + "\n" + "\n";


            System.out.println(message);

            try (FileWriter writer = new FileWriter("C:\\USR\\aa.txt",true))
            {
                writer.write(message);
                writer.flush();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }

            setVisible(false);

            GuiFormHosts app3 = new GuiFormHosts();
            app3.setVisible(true);
        }
    }

}