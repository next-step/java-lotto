package lotto.model;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    // TODO: number는 1~45 사이의 숫자여야 한다 -> 조건체크 메소드 만들기
}
