import java.util.Scanner;

public class AccumulatorRunner {
    public static void main(String[] args) {
        System.out.println("수식을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String formula = scanner.nextLine();
        PatternFormula patternFormula = new PatternFormula(formula);
        System.out.println("결과 : " + Accumulator.accumulate(patternFormula.getNumberString()));
    }
}
