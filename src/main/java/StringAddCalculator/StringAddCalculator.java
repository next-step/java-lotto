package StringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String expressions) {
        int first = Integer.parseInt(expressions.split(" ")[0]);
        for (int i = 0; i < expressions.split(" ").length; i += 2){
            String sumOperator = expressions.split(" ")[i];
            int second = Integer.parseInt(expressions.split(" ")[i+1]);
            first = calculate(expressions);
        }
        return first;
    }
}
