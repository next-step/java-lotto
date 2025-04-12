package Lotto.domain;

public class LottoNumber {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private static final LottoNumber[] CACHE = new LottoNumber[LOTTO_MAX_NUMBER +1]; // 정적 배열로 캐싱된 LottoNumber 객체를 저장 [0,1,2,...,45] 0은 사용하지 않음.

    static {
        for(int i=LOTTO_MIN_NUMBER; i<=LOTTO_MAX_NUMBER; i++) {
            CACHE[i] = new LottoNumber(i);
        }
    }

    private final int number;

    private LottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    "입력된 번호: " + number + "는 적절하지 않습니다. " +
                            LOTTO_MIN_NUMBER + " ~ " + LOTTO_MAX_NUMBER + " 사이의 값을 입력해 주세요."
            );
        }
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(  "입력된 번호: " + number + "는 적절하지 않습니다. " +
                    LOTTO_MIN_NUMBER + " ~ " + LOTTO_MAX_NUMBER + " 사이의 값을 입력해 주세요.");
        }
        return CACHE[number];
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
