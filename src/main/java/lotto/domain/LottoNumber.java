package lotto.domain;

public class LottoNumber {

    private Integer number;

    public LottoNumber(int number) { }


    public static LottoNumber of(int number) {

        validate(number);

        return new LottoNumber(number);
    }

    public static void validate(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 0보다 커야합니다.");
        }

        if(number > 45) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 45보다 작거나 같아야 합니다.");
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        LottoNumber lotto = (LottoNumber) obj;
        return number == ((LottoNumber) obj).number;
    }
}
