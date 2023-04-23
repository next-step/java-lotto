package step1;

public class Division implements Operator {
    @Override
    public int apply(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        if (x % y != 0) {
            throw new IllegalArgumentException("나눗셈의 경우 결과 값은 정수여야 합니다");
        }
        return x / y;
    }
}
