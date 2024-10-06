package textcalculator;

import java.util.Scanner;

public class ConsoleInputView implements InputView{
    public static final String INPUT_FORMULA_MESSAGE = "계산식을 입력하세요.";

    public String getFormulaFromUser() {
        System.out.println(INPUT_FORMULA_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();

        if(formula == null || formula.isBlank()){
            throw new IllegalArgumentException("계산식은 필수 입력 값입니다");
        }
        return formula;
    }
}
