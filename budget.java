import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class budget extends JFrame {

    JFrame budget = new JFrame();
    JTextArea budgetText = new JTextArea(); //reasons text
    JButton reasons = new JButton("Reasons to save");
    JButton change = new JButton("Make changes");
    JTextArea userbudget = new JTextArea();
    JScrollPane editscroll = new JScrollPane(budgetText, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    public void init(){

        budget.setBounds(0, 0, homepage.width, homepage.height);
        editscroll.setBounds(0, 100, 300, 300);
        reasons.setBounds(0, 50, 300, 50);
        change.setBounds(0, 400, 300, 50);
        reasons.setLayout(null);
        //homepage.topbar.setBounds(0, 0, 800, 50);
        budget.add(homepage.topbar);
        budget.add(homepage.lowbar);

        budget.add(editscroll);
        budget.add(reasons);
        budget.add(change);
        budget.getContentPane().setLayout(null);
        budget.setLocationRelativeTo(null);
        budget.setVisible(true);
    }
    
    
}
