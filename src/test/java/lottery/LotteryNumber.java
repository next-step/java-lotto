package lottery;

public class LotteryNumber {

    public LotteryNumber(String s) {
        if (Integer.parseInt(s) > 45 || Integer.parseInt(s) < 1) {
            throw new IllegalArgumentException("로또번호는 1 ~ 45 사이의 숫자이어야 합니다.");
        }
    }
}
