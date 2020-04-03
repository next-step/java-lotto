package lotto.model.lottos;

import lotto.model.Rank;
import lotto.model.winninglotto.WinningLotto;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.Messages.WARNING_LOTTO_NON_DUPLICATION;
import static lotto.Messages.WARNING_LOTTO_SIZE;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lotto) {
        validateSizeSix(lotto);
        validateDuplication(lotto);
        this.lottoNumbers = Collections.unmodifiableList(lotto);
    }

    public boolean hasBonusBallNumber(LottoNumber bonusBall){
        return lottoNumbers.contains(bonusBall);
    }

    public Rank match(WinningLotto winningLotto) {
        int matchCount = findMatchCount(winningLotto.getLotto());
        boolean hasBonusBall = hasBonusBall(winningLotto.getBonusBall());
        return Rank.getMatchResult(matchCount, hasBonusBall);
    }

    private int findMatchCount(List<LottoNumber> winningLotto){
        return winningLotto.stream()
                .filter(it -> lottoNumbers.contains(it))
                .collect(collectingAndThen(toList(), Collection::size));
    }

    private boolean hasBonusBall(LottoNumber bonusNumber){
        return lottoNumbers.contains(bonusNumber);
    }

    private void validateSizeSix(List<LottoNumber> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(WARNING_LOTTO_SIZE);
        }
    }

    private void validateDuplication(List<LottoNumber> lotto) {
        Set<LottoNumber> normalLotto = new HashSet<>(lotto);

        if (normalLotto.size() != 6) {
            throw new IllegalArgumentException(WARNING_LOTTO_NON_DUPLICATION);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}