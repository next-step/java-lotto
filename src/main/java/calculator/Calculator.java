package calculator;

public class Calculator {
    private String[] data;

    public Calculator(String line) {
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자일 수 없습니다.");
        }
        this.data = line.split(" ");
    }

    public String calculate() {
        int result = Integer.parseInt(data[0]);
        for (int i = 0; i < data.length - 1; i += 2) {
            result = Operator.operate(result, data[i + 1], Integer.parseInt(data[i + 2]));
        }
        return Integer.toString(result);
    }

}

