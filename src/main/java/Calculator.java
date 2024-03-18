public class Calculator {

    public int calculate(String input) {
        String[] strings = input.split(" ");
        return Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
    }
}
