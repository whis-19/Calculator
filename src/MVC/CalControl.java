package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalControl implements ActionListener {
    private CalView view;
    private CalModel model;
    private double num1, num2;
    private String operation;

    CalControl(CalView view, CalModel model) {
        this.view = view;
        this.model = model;


        this.view.addCalcListener(this);
    }

    // Action listener for the buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            // Number button logic
            if (command.matches("\\d")) {
                view.setDisplayValue(view.getDisplayValue() + command);
            }

            // Operator button logic
            else if (command.equals("+") || command.equals("-") || command.equals("/") || command.equals("*") || command.equals("%")) {
                num1 = Double.parseDouble(view.getDisplayValue());
                operation = command;
                view.setDisplayValue("");
            }

            // Equals button logic
            else if (command.equals("=")) {
                num2 = Double.parseDouble(view.getDisplayValue());
                double result = performCalculation(num1, num2, operation);
                view.setDisplayValue(String.valueOf(result));
            }

            // Clear button logic
            else if (command.equals("C")) {
                view.setDisplayValue("");
            }

            // Back button logic (resets the operation)
            else if (command.equals("B")) {
                view.setDisplayValue("");
                operation = null;
            }

        } catch (Exception ex) {
            view.setDisplayValue("Error");
        }
    }

    // Perform the calculation based on the selected operation
    private double performCalculation(double num1, double num2, String operation) {
        switch (operation) {
            case "+":
                return model.add(num1, num2);
            case "-":
                return model.sub(num1, num2);
            case "/":
                return model.div(num1, num2);
            case "*":
                return model.mult(num1, num2);
            case "%":
                return model.mod(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
