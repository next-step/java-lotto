package lotto;

import java.util.*;

import static java.lang.String.format;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public static LottoNumbers publish(ShuffleStrategy shuffleStrategy) {
        List<LottoNumber> lottoNumbers = LottoNumber.listOf(LOTTO_NUMBERS_SIZE, shuffleStrategy);
        return new LottoNumbers(lottoNumbers);
    }

    // TODO: [2021/11/15 양동혁] 중복 테스트
    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        checkLottoNumbersSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        Collections.sort(lottoNumbers);
    }

    private static void checkLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(format("로또번호는 %s 개 여야합니다.", LOTTO_NUMBERS_SIZE));
        }
    }

    public List<LottoNumber> lottoNumbers() {
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }

    public Grade rank(LottoNumbers lastWinningNumbers) {
        checkNotNull(lastWinningNumbers);
        Set<LottoNumber> allNumbers = mergeWithLottoNumbers(lastWinningNumbers.lottoNumbers);
        return Grade.from(LOTTO_NUMBERS_SIZE * 2 - allNumbers.size());
    }

    private static void checkNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("필수 값이 없습니다.");
        }
    }

    private Set<LottoNumber> mergeWithLottoNumbers(List<LottoNumber> winningNumbers) {
        Set<LottoNumber> allNumbers = new HashSet<>();
        allNumbers.addAll(lottoNumbers);
        allNumbers.addAll(winningNumbers);
        return allNumbers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
