package step3.model;

import step2.util.RandomUtil;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    private final static String RANGE_LOTTO_NUM_MESSAGE = "로또번호는 1~45범위안에 포함되야 합니다.";

    private final static int MINIMUM_LOTTO_NUM = 1;
    private final static int MAXIMUM_LOTTO_NUM = 45;

    private int number;

    public LottoNumber() {
        createLottoNum();
    }

    public LottoNumber(int number) {
        confirmLottoNumRange(number);
        this.number = number;
    }

    //일치하는 로또 번호가 있는지 확인한다.
    public boolean confirmLottoNum(int number) {
        return number == this.number;
    }

    public int getNumber() {
        return number;
    }

    //로또 번호를 생성한다.
    private void createLottoNum() {
        this.number = RandomUtil.randomNum();
    }

    // LottoNumber 정렬을 위해 compareTo 메서드 추가
    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return Objects.equals(this.number, lottoNumber.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }

    //번호가 1~45 범위에 포함되는지 체크한다.
    private void confirmLottoNumRange(int num) {
        if (num < MINIMUM_LOTTO_NUM || num > MAXIMUM_LOTTO_NUM) {
            throw new IllegalArgumentException(RANGE_LOTTO_NUM_MESSAGE);
        }
    }
}
