package lotto.domain.lotto;

import static lotto.utils.Constants.LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.error.exception.DuplicateLottoNumberException;
import lotto.error.exception.SizeExceedLottoException;

public class Lotto {

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new SizeExceedLottoException(lotto.size());
        }

        if (hasDuplicateNumbers(lotto)) {
            throw new DuplicateLottoNumberException(lotto);
        }

        this.lotto = lotto;
    }

    public static List<Lotto> createAutoLottos(int purchaseCount) {
        return IntStream.range(0, purchaseCount)
            .mapToObj(i -> new Lotto(LottoNumber.createRandomLottoNumbers()))
            .collect(Collectors.toList());
    }

    public static Lotto fromValues(List<Integer> values) {
        List<LottoNumber> lottoNumbers = values.stream()
            .map(LottoNumber::fromInt)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    private boolean hasDuplicateNumbers(List<LottoNumber> lotto) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(lotto);
        return uniqueNumbers.size() != lotto.size();
    }

    public boolean contains(LottoNumber winningNumber) {
        return lotto.contains(winningNumber);
    }

    public int size() {
        return lotto.size();
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
