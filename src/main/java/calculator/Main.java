package calculator;

public class Main {

    public static void main(String[] args) {

        View view = new View();

        //계산식 입력
        String input = view.getString();

        //입력 문자열 분리 & 계산
        Integer result = calculation(new Seperator().split(input));

        //결과 출력
        view.getResult(result);
    }

    private static Integer calculation(String[] text) {
        Operator operator = new Operator();
        Seperator seperator = new Seperator();
        Integer result = Integer.parseInt(text[0]);

        for (int i = 1; i <= Math.floor((double) text.length / 2); i++) {
            seperator.isOperator(text[2 * i - 1]);
            result = operator.operation(text[2 * i - 1], String.valueOf(result), text[2 * i]);
        }

        return result;
    }
}
