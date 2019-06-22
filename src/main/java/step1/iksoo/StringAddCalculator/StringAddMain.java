package step1.iksoo.StringAddCalculator;

public class StringAddMain {
    static StringAddCalculator stringAddCalculator = new StringAddCalculator();

    public static void main(String[] args) {
        int addResult = stringAddCalculator.add("2,5,6,88,3,4");
        Output.printTextln(addResult);
    }
}
