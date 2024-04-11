import calculator.ui.InputView;

public class Main {

    public static void main(String[] argvs){
        InputView.print();
        String expression = InputView.input();

        System.out.println(expression);
    }
}
