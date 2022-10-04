package calculator.view;

public class Output {

    private final static String CALCULATE_RESULT = "계산 결과: ";

    public void print(int calculationResult) {
        System.out.println(CALCULATE_RESULT + calculationResult);
    }
}
