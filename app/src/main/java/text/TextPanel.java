package text;

import javax.swing.*;
import java.util.ArrayList;

public class TextPanel extends JPanel {
    private ArrayList<JTextField> textFieldList;

    public  TextPanel(int axis){
        super();
        this.setLayout(new BoxLayout(this,axis)); 
        textFieldList = new ArrayList<>();
    }

    public ArrayList<JTextField> addTextFields(int fields){
        int f;
        JTextField textField;
        for (f = 0; f < fields; f++) {
            textField = new JTextField();
            this.add(textField);
            textFieldList.add(f,textField);
        }
        return(textFieldList);
    }
    
}
