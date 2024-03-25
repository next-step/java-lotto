package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.error.exception.SizeExceedLottoException;

public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        if (lotto.size() > 6) {
            throw new SizeExceedLottoException(lotto.size());
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
