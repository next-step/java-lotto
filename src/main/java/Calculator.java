public class Calculator {

    public int calculate(String input) {
        String[] strings = input.split(" ");
        int result = Integer.parseInt(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if (i % 2 == 0 && "+".equals(strings[i - 1])) {
                result += Integer.parseInt(strings[i]);
            }

            if (i % 2 == 0 && "-".equals(strings[i - 1])) {
                result -= Integer.parseInt(strings[i]);
            }
        }
        return result;
    }
}
