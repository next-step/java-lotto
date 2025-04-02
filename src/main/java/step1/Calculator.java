package step1;

public class Calculator {
    private static final String DELIMITER = " ";
    private String[] strs;

    Calculator(String str) {
        validate(str);
        this.strs = splitString(str);
    }

    public static String[] splitString(String str) {
        return str.split(DELIMITER);
    }

    private static void validate(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("공백이 입력될 수 없습니다.");
        }
    }

    public int calculate() {
        int result = Integer.parseInt(strs[0]);
        for(int i = 1; i < strs.length; i+=2) {
            int nextNumber = Integer.parseInt(strs[i + 1]);

            String symbol = strs[i];
            Operator op = StringOperator.from(symbol);
            result = op.apply(result, nextNumber);
        }

        return result;
    }
}

