import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiFormSet extends JFrame {


    private JTextField inputDestDir = new JTextField("/home/PROJECTS/ARIADNA_VERS/DATE_COPY");
    private JTextField inputAmountCopyOnServ = new JTextField("10");


    private JLabel labelSilent = new JLabel("Запрет вывода сообщений на экран");
    private JLabel labelDestDir = new JLabel("Каталог, в котором будет создаваться архив:");
    private JLabel labelAmountCopyOnServ = new JLabel("Количество копий на сервере изделия");
    private JLabel labelСheckArc = new JLabel("Проверка собранного архива");
    private JLabel labelCreateCopyServ = new JLabel("Создать копию на сервере");



    private JCheckBox checkSilent = new JCheckBox("", false);
    private JCheckBox checkCheckArc = new JCheckBox("", false);
    private JCheckBox checkCreateCopyServ = new JCheckBox("", false);

    private JButton button = new JButton("Далее");



    public GuiFormSet() {
        super("Настройки архивной копии GetArc");
        this.setBounds(200,200,900,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));


        container.add(labelSilent);
        container.add(checkSilent);

        container.add(labelDestDir);
        container.add(inputDestDir);

        container.add(labelAmountCopyOnServ);
        container.add(inputAmountCopyOnServ);

        container.add(labelСheckArc);
        container.add(checkCheckArc);

        container.add(labelCreateCopyServ);
        container.add(checkCreateCopyServ);

        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }






    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";

            message += "[ARC_SETUP]" + "\n";
            message += "Silent=" + ((checkSilent.isSelected())
                    ?"1":"0") + "\n";
            message += "DestDir=" + inputDestDir.getText() + "\n";
            message += "AmountCopyOnServ=" + inputAmountCopyOnServ.getText() + "\n";
            message += "CheckArc=" + ((checkCheckArc.isSelected())
                    ?"1":"0") + "\n";
            message += "CreateCopyOnServ=" + ((checkCreateCopyServ.isSelected())
                    ?"1":"0") + "\n";
            message += "[ARC_SETUP]" + "\n";

            System.out.println(message);
            System.exit(0);
        }
    }

}