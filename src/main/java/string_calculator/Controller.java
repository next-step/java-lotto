package string_calculator;

public class Controller {
    public Parser parser = new Parser();
    private Calculator calculator = new Calculator();

    public Controller() {
    }

    public String scan() {
        return InputView.scan();
    }
    
    public void parse(String equation) {
        this.parser.parse(equation);
    }

    public int computes() {
        return calculator.computes(this.parser.values);
    }
    
    public void print(int result) {
        ResultView.print(result);
    }
}
