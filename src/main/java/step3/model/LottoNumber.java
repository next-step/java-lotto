package step3.model;

import step2.util.RandomUtil;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    private int number;

    public LottoNumber() {
        createLottoNum();
    }

    public LottoNumber(int number) {
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
}
