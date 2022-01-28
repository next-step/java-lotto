import view.InputView;

public class Application {
    public static void main(String[] args) {
        String unrefinedFormula = InputView.readFormula();

        System.out.println(unrefinedFormula);
    }
}
