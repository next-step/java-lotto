package string_calculator;

public class Controller {
    private String equation;
    public Parser parser = new Parser();
    private Calculator calculator = new Calculator();
    public Integer result;

    public Controller() {
    }

    public Controller(String equation) {
        this.equation = equation;
    }

    public void scan() {
        this.equation = InputView.scan();
    }
    
    public void parse() {
        this.parser.parse(this.equation);
    }

    public void computes() {
        this.result = calculator.computes(this.parser.values);
    }
    
    public void print() {
        ResultView.print(this.result);
    }
}
