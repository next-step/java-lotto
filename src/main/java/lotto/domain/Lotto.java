package lotto.domain;

import lotto.exception.LottoDuplicateNumberException;
import lotto.exception.NumberOfLottoNumberException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int SIX = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validNumberOfLottoNumber(lotto);
        validDuplicate(lotto);
        this.lotto = lotto;
    }

    private void validNumberOfLottoNumber(List<LottoNumber> lotto) {
        if (lotto.size() != SIX) {
            throw new NumberOfLottoNumberException(String.valueOf(lotto.size()));
        }
    }

    private void validDuplicate(List<LottoNumber> lotto) {
        Set<LottoNumber> duplicateLottoNumber = lotto.stream()
                .filter(i -> Collections.frequency(lotto,i) > 1)
                .collect(Collectors.toSet());

        if (!duplicateLottoNumber.isEmpty()) {
            throw new LottoDuplicateNumberException(duplicateLottoNumber);
        }
    }

    public List<LottoNumber> getLotto() {
        return new ArrayList<>(lotto);
    }

    public int lottoWinningStatus(Lotto winningLotto) {
        int count = 0;
        List<LottoNumber> winningNumbers = winningLotto.getLotto();

        for (int i = 0; i < winningNumbers.size(); i++) {
            count += isNumberMatched(winningNumbers, i, lotto);
        }

        return Prize.getValueByHit(count);
    }

    private int isNumberMatched(List<LottoNumber> winningNumbers, int i, List<LottoNumber> lottoNumbers) {
        if (winningNumbers.contains(lottoNumbers.get(i))) {
            return 1;
        }
        return 0;
    }

}
