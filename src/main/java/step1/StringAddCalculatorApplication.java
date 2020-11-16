package step1;

public class StringAddCalculatorApplication {

    public static void main(String[] args) {
        StringAddCalculator addCalculator = new StringAddCalculator();
        int result = addCalculator.splitAndSum("1,2,3");
        System.out.println(result);
    }
}
