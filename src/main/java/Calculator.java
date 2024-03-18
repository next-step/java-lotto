public class Calculator {

    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백은 계산처리가 안됩니다!");
        }
        String[] strings = input.split(" ");
        int result = Integer.parseInt(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            if (i % 2 == 1 && !"+".equals(strings[i]) && !"-".equals(strings[i]) && !"*".equals(strings[i]) && !"/".equals(strings[i])) {
                throw new IllegalArgumentException("사칙연산으로만 계산이 가능합니다!");
            }

            if (i % 2 == 0 && "+".equals(strings[i - 1])) {
                result += Integer.parseInt(strings[i]);
            }

            if (i % 2 == 0 && "-".equals(strings[i - 1])) {
                result -= Integer.parseInt(strings[i]);
            }

            if (i % 2 == 0 && "*".equals(strings[i - 1])) {
                result *= Integer.parseInt(strings[i]);
            }

            if (i % 2 == 0 && "/".equals(strings[i - 1])) {
                result /= Integer.parseInt(strings[i]);
            }
        }
        return result;
    }
}
