import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class GuiFormBasic extends JFrame {

    private JTextField inputArchServer = new JTextField("192.169.11.55");
    private JTextField inputSrcDir = new JTextField("/home/PROJECTS");
    private JTextField inputPrjName = new JTextField("ARIADNA");
    private JTextField inputPlatfName = new JTextField("RIO");
    private JTextField inputReportRecList = new JTextField("d.koryakovsky@op.local");

    private JLabel labelSrcDir = new JLabel("Путь к архиву ПО ЦВК");
    private JLabel labelPrjName = new JLabel("Имя проекта");
    private JLabel labelArchServer = new JLabel("Архивный сервер изделия");
    private JLabel labelPlatfName = new JLabel("Выбор платформы");
    private JLabel labelReportRecList = new JLabel("Список email адресов получателей отчета о работе программы");


    private JButton button = new JButton("Далее");




    public GuiFormBasic() {
        super("Основные настройки GetArc");
        this.setBounds(200,200,1100,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));
        container.add(labelArchServer);
        container.add(inputArchServer);

        container.add(labelSrcDir);
        container.add(inputSrcDir);

        container.add(labelPrjName);
        container.add(inputPrjName);

        container.add(labelPlatfName);
        container.add(inputPlatfName);

        container.add(labelReportRecList);
        container.add(inputReportRecList);

        container.add(button);


        button.addActionListener(new ButtonEventListener());
    }






    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";

            message += "[COMMON]" + "\n";
            message += "ArchServer=" + inputArchServer.getText() + "\n";
            message += "SrcDir=" + inputSrcDir.getText() + "\n";
            message += "PrjName=" + inputPrjName.getText() + "\n";
            message += "PlatfName=" + inputPlatfName.getText() + "\n";
            message += "ReportRecList=" + "\"" + inputReportRecList.getText() + "\"" + "\n";
            message += "[COMMON]" + "\n" + "\n";


            System.out.println(message);

            try (FileWriter writer = new FileWriter("C:\\USR\\aa.txt",false))
            {
                writer.write(message);
                writer.flush();
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }

            setVisible(false);


            GuiFormSet app2 = new GuiFormSet();
            app2.setVisible(true);
        }
    }

}