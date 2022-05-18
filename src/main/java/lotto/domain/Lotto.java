package lotto.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    public final static int LOTTO_LENGTH = 6;
    public final static int LOTTO_START_NUMBER = 1;
    public final static int LOTTO_END_NUMBER = 45;
    public final static int LOTTO_PRICE = 1000;

    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    Lotto(int num1, int num2, int num3, int num4, int num5, int num6) {
        this(Set.of(num1, num2, num3, num4, num5, num6));
    }

    public Lotto(Set<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("숫자 " + LOTTO_LENGTH + "개만 입력 가능합니다");
        }

        for (int number : numbers) {
            this.lottoNumbers.add(new LottoNumber(number));
        }
    }

    public static Lotto of(String lottoString) {
        String[] numberArray = lottoString.split(", ");

        Set<Integer> lottoNumbers = new HashSet<>();
        for (int i = 0; i < LOTTO_LENGTH; ++i) {
            lottoNumbers.add(Integer.parseInt(numberArray[i]));
        }

        return new Lotto(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoReward hasWinningNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        int result = 0;
        for (LottoNumber winningNumber : winningLotto.lottoNumbers) {
            result += addMatchResult(hasNumber(winningNumber));
        }

        boolean isBonusMatched = hasNumber(bonusNumber);

        return LottoReward.of(result, isBonusMatched);
    }

    private int addMatchResult(boolean matched) {
        if (matched) {
            return 1;
        }

        return 0;
    }

    boolean hasNumber(LottoNumber lottoNumber) {
        return lottoNumbers.stream().anyMatch(n -> n.equals(lottoNumber));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) obj;
        return this.lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
