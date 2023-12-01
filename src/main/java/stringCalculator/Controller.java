package stringCalculator;

public class Controller {

    public static void main(String[] args){
        InputView inputView = new InputView();
        Calculator cal = new Calculator();
        String input = inputView.inputString();

        try {
            int result = cal.calculate(input);
            System.out.println("결과값 : " + result);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
