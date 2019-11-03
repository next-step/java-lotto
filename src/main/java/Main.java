import adder.IntegerAdder;

public class Main {
    public static void main(String[] args) {
        String input = "//&\\n1&2&3&4";
        IntegerAdder adder = new IntegerAdder(input);
        System.out.println(adder.calculate());
    }
}
