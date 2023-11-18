package lotto.type;

/**
 * 로또 번호나 당첨 번호에 사용되는 번호 1개를 나타냅니다.
 * 불변 객체입니다.
 */
public class SingleNumber implements Comparable<SingleNumber> {

    /** 로또 번호 하한선 (경계값 포함) */
    private static final int MIN_NUM = 1;

    /** 로또 번호 상한선 (경계값 포함) */
    private static final int MAX_NUM = 45;

    private final int lottoNumber;

    /**
     * 로또 번호나 당첨 번호에 사용되는 번호를 생성합니다.
     * int 타입을 wrapping합니다.
     * 불변 객체입니다.
     */
    public SingleNumber(int lottoNumber) {
        checkRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    /**
     * 로또 번호나 당첨 번호에 사용되는 번호를 생성합니다.
     * int 타입을 wrapping합니다.
     * 불변 객체입니다.
     */
    public static SingleNumber of(int lottoNumber) {
        return new SingleNumber(lottoNumber);
    }

    /**
     * 로또 번호가 가능한 범위를 제한합니다.
     *
     * @param num 검사할 번호
     */
    private static void checkRange(int num) {
        if (num < MIN_NUM) {
            throw new IllegalArgumentException("주어진 번호는 " + num + "로 "+MIN_NUM+" 미만입니다.");
        }

        if (num > MAX_NUM) {
            throw new IllegalArgumentException("주어진 번호는 " + num + "로 "+MAX_NUM+" 초과입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SingleNumber that = (SingleNumber) o;

        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }

    @Override
    public int compareTo(SingleNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }

    /**
     * 이 타입과 호환되지 않는 곳에서 값을 사용하기 위해 정수로 변환합니다.
     *
     * @return 정수값
     */
    public int toInt() {
        return this.lottoNumber;
    }
}