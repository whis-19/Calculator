package MVC;


public class CalDriver {
    public static void main(String[] args) {
        CalView view = new CalView();
        CalModel model = new CalModel();
        CalControl controller = new CalControl(view, model);
        
        view.setVisible(true); 
    }
}
