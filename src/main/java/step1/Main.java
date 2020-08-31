package step1;

public class Main {

    public static void main(String[] args) {

        StringPlusCalculator calculator = new StringPlusCalculator();

        String factors = "1,2:3";
        int result = calculator.calculate(factors);
        System.out.println(result);

    }

}
