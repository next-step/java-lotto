package step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    private int value; // 로또 1장에 포함된 숫자 1개

    public LottoNumber(int number) {
        this.value = number;
    }

    public int getNumber() {
        return this.value;
    }

    public boolean checkValidation() {
        // 1 ~ 45 범위 체크
        return true;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (lottoNumber.value < value) {
            return 1;
        } else if (lottoNumber.value > value) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) { // 인스턴스 내의 값 비교
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() { // 인스턴스 메모리 주소
        return Objects.hash(value);
    }
}
