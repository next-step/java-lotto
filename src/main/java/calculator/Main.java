package calculator;

import calculator.model.*;
import calculator.view.Input;
import calculator.view.Output;



public class Main {

    public static void main(String[] args) {
        Application application = new Application();
        String exp = Input.readExp();

        try{
            Output.printResult(application.calculate(exp));
        }catch (Exception exception){
            System.out.println(String.join("\n", "ERROR", exception.getMessage()));
        }
    }
}
