import java.awt.Component;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class homepage extends JFrame{

Timer timer = new Timer("Display Timer");

//variables to be used in every window
public static int width = 800;
public static int height = 600;
int bwidth = 200;
int bheight = 100;

JFrame homepage = new JFrame();
static JTextField topbar = new JTextField();
static JTextField lowbar = new JTextField();
JLabel addPic = new JLabel();

//all other class objets are initialized here
static todo ToDoList = new todo();
static budget Budget = new budget();
static notes Notes = new notes();

//////////////////////////////////////////////

Font listfont = new Font("SansSerif", Font.BOLD, 12);
public void init(){
    
    topbar.setBounds(0, 0, 800, 50);
    topbar.setFont(listfont);
    todo.setBounds(0, 50, bwidth, bheight);
    budget.setBounds(0, 150, bwidth, bheight);
    notes.setBounds(0, 250, bwidth, bheight);
    goals.setBounds(0, 350, bwidth, bheight); //bottom reaches 450
    lowbar.setBounds(0, 450, 800, 150);
    

    homepage.add(topbar);
    homepage.add(todo);
    homepage.add(budget);
    homepage.add(notes);
    homepage.add(goals);
    homepage.add(lowbar);
    homepage.getContentPane().setLayout(null);
    homepage.setBounds(300, 300, width, height);
    homepage.setLocationRelativeTo(null);
    homepage.setVisible(true);
    homepage.setDefaultCloseOperation(EXIT_ON_CLOSE);

  
    
}

JButton todo = new JButton( new AbstractAction("To Do List") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        ToDoList.init();
        homepage.dispose();
    }

});

JButton budget = new JButton( new AbstractAction("Budget") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        Budget.init();

    }

});

JButton notes = new JButton( new AbstractAction("Notes") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        Notes.init();
    }

});

JButton goals = new JButton( new AbstractAction("Goals") {
    @Override
    public void actionPerformed( ActionEvent e ) {
    }

});


//*method creates timer, ticks it, adds it to the top bar */
TimerTask task = new TimerTask() {
    @Override
    public void run() {
        // Task to be executed every second
            try {
                SwingUtilities.invokeAndWait(new Runnable() {

                    @Override
                    public void run() {
                        DateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
                        Calendar cali = Calendar.getInstance();
                        cali.getTime();
                        String time = timeFormat.format(cali.getTimeInMillis());
                       // System.out.println(timeFormat.format(cali.getTimeInMillis()));
                        topbar.setText(time);

                        timer.scheduleAtFixedRate(task, 1000, 1000);

                    }
                });
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        

    } 
}; 

    
}
