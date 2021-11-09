import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.Font;

public class todo extends JFrame {
    
File file = new File("todolist.txt");

public static int width = 800;
public static int height = 600;
int bwidth = 200;
int bheight = 100;

JFrame todoFrame = new JFrame(); //main window
JFrame addtaskWindow = new JFrame(); //secondary pop up window

JTextField topbar = new JTextField();
JTextField lowbar = new JTextField();

JTextArea list = new JTextArea(); 
JTextArea userAddTask = new JTextArea();
Font listfont = new Font("SansSerif", Font.BOLD, 12);
JScrollPane listcon = new JScrollPane(list);
JScrollPane editscroll = new JScrollPane(userAddTask, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

public static int listw = 300;
public static int listh = 50;
public void init(){
    
    todo.setBounds(0, 50, bwidth, bheight);
    budget.setBounds(0, 150, bwidth, bheight);
    notes.setBounds(0, 250, bwidth, bheight);
    goals.setBounds(0, 350, bwidth, bheight); //bottom reaches 450
    lowbar.setBounds(0, 450, 800, 150);
    listcon.setBounds(200, 50, 350, 400);
    listcon.setLayout(null);
    userAddTask.setFont(listfont);
    list1.setBounds(0, 0, listw, listh);
    list1.setText("untitled1");
    list1.setBackground(Color.WHITE);
    list2.setBounds(0, 50, listw, listh);
    list2.setBackground(Color.WHITE);
    list3.setBounds(0, 100, listw, listh);
    list3.setBackground(Color.WHITE);
    list4.setBounds(0, 150, listw, listh);
    list3.setBackground(Color.WHITE);
    


    todoFrame.add(homepage.topbar);
    todoFrame.add(todo);
    todoFrame.add(budget);
    todoFrame.add(notes);
    todoFrame.add(goals);
    todoFrame.add(lowbar);
    todoFrame.getContentPane().add(listcon);
    listcon.add(list1);
    listcon.add(list2);
    listcon.add(list3);
    todoFrame.getContentPane().setLayout(null);
    todoFrame.setBounds(300, 300, width, height);
    todoFrame.setLocationRelativeTo(null);
    todoFrame.setVisible(true);

    displayListtoWindow();
    
}


public void displayListtoWindow(){ 
        
    // toDo.setBounds(150, 150, 300, 200);
  //  toDo.setFont(font1);
  //  scroll.setBounds(200, 50, 300, 200);

     try (Reader myReader = new BufferedReader(new FileReader("todolist.txt"))) {
        // toDo.read(myReader);
        // list.read(myReader, "do to list");
         userAddTask.read(myReader, "do to list");

     } catch (IOException exp) {
         exp.printStackTrace();
     }
 }

public void confirmEdit() throws IOException{

        FileWriter fwOb = new FileWriter("todolist.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();


    FileWriter fw = new FileWriter(file, true);
   // BufferedWriter bw = new BufferedWriter(fw);
    
    fw.write(userAddTask.getText());
   // fw.newLine();
    fw.close();


}

JButton todo = new JButton( new AbstractAction("Home") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

public void addTask(){
    addtaskWindow.setBounds(0,0, 400, 400);
   // userAddTask.setBounds(50, 50, 300, 150);
    editscroll.setBounds(50, 50, 300, 150);
    Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
    userAddTask.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    confirmList.setBounds(50, 300, 100, 50);
 

    addtaskWindow.getContentPane().add(editscroll);
    //addtaskWindow.add(userAddTask);
    displayListtoWindow();
    addtaskWindow.add(confirmList);
    userAddTask.setVisible(true);
    addtaskWindow.add(confirmList);
    addtaskWindow.setLocationRelativeTo(null);
    addtaskWindow.setLayout(null);
    addtaskWindow.setVisible(true);
}

public void editListTitle(JButton j){

    
    String a = j.getText(); //gets the title of button
    int i = a.charAt(8);

    try {
        String editLine = Files.readAllLines(Paths.get("listnames.txt")).get(i);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    
}
//only methods: add task and confirm
JButton budget = new JButton( new AbstractAction("Add Task") {

    @Override
    public void actionPerformed( ActionEvent e ) {
        addTask();
    try {
        confirmEdit();
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    }

});

JButton confirmList = new JButton( new AbstractAction("confirm") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        try {
            confirmEdit();
            addtaskWindow.dispose();
            addTask();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
});

//// not really used anymore because user edits entire list in first window
JButton notes = new JButton( new AbstractAction("Delete Task") {
    @Override
    public void actionPerformed( ActionEvent e ) {
    JFrame removetask = new JFrame();
    removetask.setBounds(0,0, 400, 400);

    removetask.setLocationRelativeTo(null);
    removetask.setVisible(true);

    }

});

JButton goals = new JButton( new AbstractAction("Clear List") {
    @Override
    public void actionPerformed( ActionEvent e ) {
    }

});

JButton list1 = new JButton( new AbstractAction("untitled 1") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        addTask(); //has button confirm list, which calls method 
                  // confirm edit
       // todoFrame.dispose();
    }

});

JButton list2 = new JButton( new AbstractAction("untitled 2") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

JButton list3 = new JButton( new AbstractAction("untitled 3") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

JButton list4 = new JButton( new AbstractAction("untitled 4") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

JButton list5 = new JButton( new AbstractAction("untitled 5") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

JButton list6 = new JButton( new AbstractAction("untitled 6") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

JButton list7 = new JButton( new AbstractAction("untitled 7") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

JButton list8 = new JButton( new AbstractAction("untitled 8") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

JButton list9 = new JButton( new AbstractAction("untitled 9") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

JButton list10 = new JButton( new AbstractAction("untitled 10") {
    @Override
    public void actionPerformed( ActionEvent e ) {
        main.home.init();
        todoFrame.dispose();
    }

});

    
}
