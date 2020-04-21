package Lotto;

public class LottoNumber {

    private final int LOTTO_NUMBER_BOUND = 45;

    int number;

    public LottoNumber(int number) {

        if (number > LOTTO_NUMBER_BOUND || number <= 0) {
            throw new RuntimeException("로또번호는 45 이상, 0 이하가 될 수 없습니다.");
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
