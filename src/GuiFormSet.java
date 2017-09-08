import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class GuiFormSet extends JFrame {


    private JTextField inputDestDir = new JTextField("/home/PROJECTS/ARIADNA_VERS/DATE_COPY");
    private JTextField inputIPCopyServ = new JTextField("192.168.62.2");
    private JTextField inputProjPathCopyOnServ = new JTextField("/arc/home/PROJECTS/CURRENT/ARIADNA/VERSIONS");
    private JTextField inputExcludeObjList = new JTextField("*.OLD *.old *.Old *.sav *.Sav *.SAV *.blank *.bad *.Bad *.BAD *.cap .depend *.a *.o");


    private JLabel labelSilent = new JLabel("Запрет вывода сообщений на экран");
    private JLabel labelDestDir = new JLabel("Каталог, в котором будет создаваться архив");
    private JLabel labelСheckArc = new JLabel("Проверка собранного архива");
    private JLabel labelCreateCopyServ = new JLabel("Создать копию на сервере");
    private JLabel labelIPCopyServ = new JLabel("IP-адрес сервера архивных копий");
    private JLabel labelIProjPathCopyOnServ = new JLabel("Путь для копирования собранного архива");
    private JLabel labelExcludeObjList = new JLabel("Список обьектов для исключения при копировании");
    private JLabel labelSPOLastVer = new JLabel("Копирование последних версий СПО из каьалога COMMON_MNT");
    private JLabel labelFMObyMake = new JLabel("Копирование версий ФПО на основе Makefile-s");
    private JLabel labelSetAcc = new JLabel("Выставить атрибуты разрешения общего доступа к файлам и каталогам");
    private JLabel labelArcNewVer = new JLabel("Создать новую версию архива (например: текущая 3.1, будет 3.2)");



    private JCheckBox checkSilent = new JCheckBox("", false);
    private JCheckBox checkCheckArc = new JCheckBox("", false);
    private JCheckBox checkCreateCopyServ = new JCheckBox("", false);
    private JCheckBox checkSPOLastVer = new JCheckBox("", false);
    private JCheckBox checkFMObyMake = new JCheckBox("", false);
    private JCheckBox checkSetAcc = new JCheckBox("", false);
    private JCheckBox checkArcNewVer = new JCheckBox("", false);


    private JButton button = new JButton("Далее");



    public GuiFormSet() {
        super("Настройки архивной копии GetArc");
        this.setBounds(200,200,1100,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0,2));


        container.add(labelSilent);
        container.add(checkSilent);

        container.add(labelDestDir);
        container.add(inputDestDir);

        container.add(labelСheckArc);
        container.add(checkCheckArc);

        container.add(labelCreateCopyServ);
        container.add(checkCreateCopyServ);

        container.add(labelIPCopyServ);
        container.add(inputIPCopyServ);

        container.add(labelIProjPathCopyOnServ);
        container.add(inputProjPathCopyOnServ);

        container.add(labelExcludeObjList);
        container.add(inputExcludeObjList);

        container.add(labelSPOLastVer);
        container.add(checkSPOLastVer);

        container.add(labelFMObyMake);
        container.add(checkFMObyMake);

        container.add(labelSetAcc);
        container.add(checkSetAcc);

        container.add(labelArcNewVer);
        container.add(checkArcNewVer);


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
            message += "CheckArc=" + ((checkCheckArc.isSelected())
                    ?"1":"0") + "\n";
            message += "CreateCopyOnServ=" + ((checkCreateCopyServ.isSelected())
                    ?"1":"0") + "\n";
            message += "IPCopyServ=" + inputIPCopyServ.getText() + "\n";
            message += "ProjPathCopyOnServ=" + inputProjPathCopyOnServ.getText() + "\n";
            message += "ExcludeObjList=" + "\"" + inputExcludeObjList.getText()+ "\"" + "\n";
            message += "SPOLastVer=" + ((checkSPOLastVer.isSelected())
                    ?"1":"0") + "\n";
            message += "FMObyMake=" + ((checkFMObyMake.isSelected())
                    ?"1":"0") + "\n";
            message += "SetAcc=" + ((checkSetAcc.isSelected())
                    ?"1":"0") + "\n";
            message += "ArcNewVer=" + ((checkArcNewVer.isSelected())
                    ?"1":"0") + "\n";
            message += "[ARC_SETUP]" + "\n" + "\n";

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

            GuiFormList app3 = new GuiFormList();
            app3.setVisible(true);

            //System.exit(0);
        }
    }

}