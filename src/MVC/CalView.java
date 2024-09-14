package MVC;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CalView extends Frame {
    private Label lbl1;
    private TextField txt1;
    private Button btnAdd, btnSub, btnDiv, btnMul, btnMod, btnEq, btnR1, btnR2, btnR3, btnR4, btnC, btnB;
    private Label lbl = new Label("Submitted by 22F-3722");

    CalView() {
        lbl1 = new Label("Display");
        txt1 = new TextField(10);
        txt1.setEditable(false);

        // Operators
        btnAdd = new Button("+");
        btnSub = new Button("-");
        btnDiv = new Button("/");
        btnMul = new Button("*");
        btnMod = new Button("%");
        btnEq = new Button("=");

        // Number buttons
        btnR1 = new Button("3");
        btnR2 = new Button("7");
        btnR3 = new Button("2");
        btnR4 = new Button("2");

        // Clear and back buttons
        btnC = new Button("C");
        btnB = new Button("B");

        // Adding components
        this.add(lbl1);
        this.add(txt1);
        this.add(btnAdd);
        this.add(btnSub);
        this.add(btnDiv);
        this.add(btnMul);
        this.add(btnMod);
        this.add(btnR1);
        this.add(btnR2);
        this.add(btnR3);
        this.add(btnR4);
        this.add(btnEq);
        this.add(btnC);
        this.add(btnB);
        this.add(lbl);

        // Layout setup
        this.setSize(350, 300);
        this.setLocation(300, 300);
        this.setLayout(new FlowLayout());

        // Closing the window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    // Method to add action listeners to buttons
    public void addCalcListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
        btnSub.addActionListener(listener);
        btnDiv.addActionListener(listener);
        btnMul.addActionListener(listener);
        btnMod.addActionListener(listener);
        btnEq.addActionListener(listener);
        btnR1.addActionListener(listener);
        btnR2.addActionListener(listener);
        btnR3.addActionListener(listener);
        btnR4.addActionListener(listener);
        btnC.addActionListener(listener);
        btnB.addActionListener(listener);
    }

    // Methods to update display
    public void setDisplayValue(String value) {
        txt1.setText(value);
    }

    public String getDisplayValue() {
        return txt1.getText();
    }
}
