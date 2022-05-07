package calculator.model;

import java.util.List;

public class Application {

    public int calculate(String exp) {
        exp = removeSpace(exp);
        List<Number> numbers = Extractor.extractNumbers(exp);
        List<Operator> operators = Extractor.extractOperator(exp);
        Calculator calculator = new Calculator(numbers, operators);
        return calculator.calculate();
    }

    public String removeSpace(String string){
        return string.replace(" ","");
    }
}
