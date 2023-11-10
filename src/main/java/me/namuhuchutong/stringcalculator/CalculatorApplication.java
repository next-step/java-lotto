package me.namuhuchutong.stringcalculator;

public class CalculatorApplication {

    public static void main(String[] args){
        Prompt prompt = new Prompt();
        String input = prompt.showStringPrompt("게산식을 입력하세요.");
        Operators operators = Operators.from(input);
        Operands operands = Operands.from(input);

        int result = operators.calculate(operands);

        prompt.printResult(result);
    }
}
