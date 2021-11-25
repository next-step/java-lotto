package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_VALUE = 1; //MAX_VALUE는 RandomUtil.randomInt(LottoNumber.MAX_VALUE)와 같이 사용해서 public인데,
    public static final int MAX_VALUE = 45; // 첫번째 위와 같이 사용해도 되는가?(사용하게 될 때 자꾸 의존성을 의식하게 됨. 독립적으로 짜야하는것 아닌가?) 두번째, MIN_VALUE는 사용안하는데 private으로 둬야하는가?

    private static final LottoNumber[] lottoNumbers = new LottoNumber[MIN_VALUE + MAX_VALUE];
    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            lottoNumbers[i] = new LottoNumber(i);
        }
    }

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) { // static valueOf를 만들었더니 validate가 static이 되버렸다..!
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("해당 로또번호는 없습니다.");
        }
    }

    public static LottoNumber valueOf(int value) {
        validate(value);
        return lottoNumbers[value];
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

}
