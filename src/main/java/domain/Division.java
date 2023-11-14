package domain;

public class Division implements Calculator{

    @Override
    public int calculator(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0 으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }
}
