package lotto.domain.ticket;

import lotto.vo.LottoMatchResult;

import java.util.List;

public class Lotto {
    private final LottoTicket lottoNumbers;
    private final LottoNumber bonusNumber;

    public Lotto(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Lotto number must be unique");
        }

        this.lottoNumbers = new LottoTicket(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

    int getMatchCounts(Lotto target) {
        return this.lottoNumbers.getNumberOfDuplicatedNumbers(target.lottoNumbers);
    }

    boolean isBonusNumberMatch(Lotto target) {
        return this.bonusNumber.isEqualTo(target.bonusNumber);
    }

    public LottoMatchResult getResult(Lotto winner) {
        int matchCounts = getMatchCounts(winner);
        boolean bonusNumberSame = isBonusNumberMatch(winner);

        return new LottoMatchResult(matchCounts, bonusNumberSame);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString() + " / " + bonusNumber;
    }
}