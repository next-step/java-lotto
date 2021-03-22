package enums;

import java.util.Arrays;

public enum WinningsPrice {

    FOUR(3,5000),
    THREE(4,50000),
    TWO(5,1500000),
    ONE(6,2000000000);

    private int count;
    private int price;

    WinningsPrice(int count, int price) {
        this.count = count;
        this.price = price;
    }

//    public static Operator of(String operator) {
//        return Arrays.stream(values())
//            .filter(op -> op.operator.equals(operator))
//            .findFirst()
//            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
//    }
//
//    public int calculate(int leftOperand, int rightOperand) {
//        return expression.apply(leftOperand, rightOperand);
//    }
}
