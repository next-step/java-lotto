package lotto.domain;

import lotto.exception.LottoDuplicateNumberException;
import lotto.exception.NumberOfLottoNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
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

        if (duplicateLottoNumber.size() >= 1) {
            throw new LottoDuplicateNumberException(makeDuplicateLottoNumberMessage(duplicateLottoNumber));
        }

    }

    private String makeDuplicateLottoNumberMessage(Set<LottoNumber> duplicateLottoNumber) {
        return duplicateLottoNumber.stream()
                .map(i -> String.valueOf(i.getLottoNumber()))
                .collect(Collectors.joining(" ","중복 요소: ","가 하나 이상 존재"));
    }

    public List<LottoNumber> getLotto() {
        return new ArrayList<>(lotto);
    }

    public int lottoWinningStatus(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        List<LottoNumber> lottoNumbers = lotto.getLotto();
        List<LottoNumber> winningNumbers = winningLotto.getLotto();

        for (int i = 0; i < winningNumbers.size(); i++) {
            count += isNumberMatched(winningNumbers, i, lottoNumbers);
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
