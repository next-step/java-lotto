package lotto.model.lottonumber;

import lotto.model.Rank;
import lotto.model.winninglotto.BonusBall;
import lotto.model.winninglotto.WinningLotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private void validateDuplication(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() > uniqueNumbers.size()) {
            throw new IllegalArgumentException("로또는 중복되지 않은 숫자로 구성되어야 합니다.");
        }
    }

    public Rank resolveRank(WinningLotto winningLotto){
        int matchCount = findHowManyMatch(winningLotto);
        boolean hasBonusBall = hasBonusBall(winningLotto.getBonusNumber());
        return Rank.findMatchResult(matchCount, hasBonusBall);
    }

    public int findHowManyMatch(WinningLotto winningLotto) {
        return this.lottoNumbers.stream()
                .filter(it -> winningLotto.contains(it))
                .collect(Collectors.toList())
                .size();
    }

    public boolean hasBonusBall(BonusBall bonusBall) {
        return lottoNumbers.stream()
                .filter(number -> bonusBall.isEqualWith(number))
                .findAny()
                .isPresent();
    }

    public boolean contains(LottoNumber lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}