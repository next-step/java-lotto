package calculator.domain;

/**
 * Created by seungwoo.song on 2022-09-27
 */
public enum CalculateType {
    NUMBER,
    OPERATOR;


    public static CalculateType parse(String text) {
        if (Operator.isOperator(text)) {
            return OPERATOR;
        }

        return NUMBER;
    }


}
