import model.Calculator;
import model.Extractor;
import model.Number;
import model.Operator;
import view.Input;
import view.Output;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        String exp = input.readExp();

        try{
            output.printResult(calculate(exp));
        }catch (Exception exception){
            System.out.println(String.join("\n", "ERROR", exception.getMessage()));
        }

    }

    public static int calculate(String exp) {
        exp = exp.replace(" ","");
        List<Number> numbers = Extractor.extractNumbers(exp);
        List<Operator> operators = Extractor.extractOperator(exp);
        Calculator calculator = new Calculator(numbers, operators);
        return calculator.calculate();
    }
}
