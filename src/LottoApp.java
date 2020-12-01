import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoApp extends JFrame implements ActionListener {

    JPanel pnl = new JPanel();
    ClassLoader classLoader = this.getClass().getClassLoader();
    java.net.URL iconURL = classLoader.getResource("Lotto2.png");
    ImageIcon icon = new ImageIcon(iconURL);
    JLabel lbl = new JLabel(icon);
    JTextField field = new JTextField("",18);
    JButton btn = new JButton("Get My Lucky Numbers");

    public LottoApp(){
        super("Lotto App");
        setSize(300,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(lbl);
        pnl.add(field);
        pnl.add(btn);
        btn.addActionListener(this);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn){
            int[] nums = new int[60];
            String str = "";
            for (int i = 1; i < 60 ; i++) {
                nums[i] = i;
            }
            for (int i = 1; i < 60; i++) {
                int r = (int)(59*Math.random())+1;
                //swap tow numbers
                int t = nums[i];
                nums[i]=nums[r];
                nums[r]=t;
            }
            for (int i = 1; i < 7; i++) {
                str += " " + nums[i] +" ";
                field.setText(str);
            }
        }
    }

    public static void main(String[] args) {
        LottoApp gui = new LottoApp();
    }
}
