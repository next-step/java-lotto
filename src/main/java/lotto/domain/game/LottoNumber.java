package lotto.domain.game;

import lotto.domain.LottoNumberBoard;

import java.util.*;

/**
 * Created By mand2 on 2020-11-19.
 */
public class LottoNumber {

    private final TreeSet<Integer> lottoNumbers;
    public static final int VALID_LOTTO_SIZE = 6;
    public static final String MESSAGE_VALID_SIZE = "한 게임당 로또 번호를 중복없이 %d개 입력해 주세요.";
    public static final String MESSAGE_VALID_NUMBER = "로또 번호는 %d ~ %d 사이의 수로만 입력합니다.";

    private LottoNumber(TreeSet<Integer> lottoNumbers) {
        isValidSize(lottoNumbers.size());
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumber of(List<Integer> lottoNumbers) {
        isValidNumber(lottoNumbers);
        return new LottoNumber(new TreeSet<>(lottoNumbers));
    }

    public List<Integer> value() {
        return Collections.unmodifiableList(new ArrayList<>(this.lottoNumbers));
    }

    private static void isValidSize(int lottoNumberSize) {
        if (lottoNumberSize != VALID_LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format(MESSAGE_VALID_SIZE, VALID_LOTTO_SIZE));
        }
    }

    private static void isValidNumber(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            checkNumber(lottoNumber);
        }
    }

    private static void checkNumber(int lottoNumber) {
        int min = LottoNumberBoard.VALID_MIN_NUMBER;
        int max = LottoNumberBoard.VALID_MAX_NUMBER;

        if ( lottoNumber < min || lottoNumber > max) {
            throw new IllegalArgumentException(String.format(MESSAGE_VALID_NUMBER, min, max));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

//    @Override
//    public String toString() {
//        return Stream.generate(this::value).map(num -> )
//    }
}
