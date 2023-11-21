package StringCalculator;

public class Controller {

    public static void main(String[] args){
        InputView inputView = new InputView();
        Calculator cal = new Calculator();
        String input = inputView.inputString();
        int result = cal.calculate(input);

        System.out.println("결과값 : " + result);
    }

}
