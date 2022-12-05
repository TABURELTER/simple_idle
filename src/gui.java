import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame{

    public JPanel mainForm;
    public JButton магазинButton;
    public JButton окноСКликамиButton;
    public JLabel balansJ;
    public JButton дайтеДенегButton;
    public JPanel buttons;
    private JPanel bui;
    private JPanel main;
    private JButton домойButton;
    private JButton далееButton;
    private JButton назадButton;
    private JButton купитьButton;
    private JLabel CPS;
    private JLabel price;
    private JLabel cpss;
    private JLabel names;

    int menu = 0;
    public gui(click clickq) {
        дайтеДенегButton.addActionListener(new ActionListener() {
//            @Override
            public void actionPerformed(ActionEvent e) {
                clickq.addf();
                updatecount(clickq.Balans);

            }
        });
        купитьButton.addActionListener(new ActionListener() {
            //            @Override
            public void actionPerformed(ActionEvent e) {
                clickq.buy(menu);
            }
        });
        магазинButton.addActionListener(new ActionListener() {
//            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                bui.setVisible(true);
            }
        });
        домойButton.addActionListener(new ActionListener() {
//            @Override
            public void actionPerformed(ActionEvent e) {
                bui.setVisible(false);
                main.setVisible(true);
            }
        });

        назадButton.addActionListener(new ActionListener() {
//            @Override
            public void actionPerformed(ActionEvent e) {
                if (menu > 0){
                    далееButton.enable();
                    menu--;
                    System.out.println("menu: "+menu);
//                    setMarket(clickq);
                }
                if (menu == 0) {
                    назадButton.disable();
                }
            }
        });

        далееButton.addActionListener(new ActionListener() {
//            @Override
            public void actionPerformed(ActionEvent e) {
                if (menu < 3){
                    menu++;
                    назадButton.enable();
                    System.out.println("menu: "+menu);
//                    setMarket(clickq);

                }
                if(menu == 3){
                    далееButton.disable();
                }
            }
        });

    }



    public void updatecount(int b){
        balansJ.setText("Печеньки: "+ b);
    }
    public void updateCPS(int b){
        CPS.setText("CPS: "+ b);
    }



    public void setMarket(click clickq) {
        Thread q = new Thread(new Runnable() {
            public void run() {
                while (true){
                    switch (menu){
                        case 0:
                            names.setText(String.valueOf(clickq.item0.name));
                            price.setText(String.valueOf((int)clickq.item0.cost));
                            cpss.setText(String.valueOf(clickq.item0.CPS));
                            break;
                        case 1:
                            names.setText(String.valueOf(clickq.item1.name));
                            price.setText(String.valueOf((int)clickq.item1.cost));
                            cpss.setText(String.valueOf(clickq.item1.CPS));
                            break;
                        case 2:
                            names.setText(String.valueOf(clickq.item2.name));
                            price.setText(String.valueOf((int)clickq.item2.cost));
                            cpss.setText(String.valueOf(clickq.item2.CPS));
                            break;
                        case 3:
                            names.setText(String.valueOf(clickq.item3.name));
                            price.setText(String.valueOf((int)clickq.item3.cost));
                            cpss.setText(String.valueOf(clickq.item3.CPS));
                            break;
                }
                }}
            });

        q.start();
    }


    public void launch() {
        setContentPane(mainForm);
        bui.setVisible(false);
        System.out.println("GUI");
        setTitle("Крестики и нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(460, 500);
        setVisible(true);


    }


}
