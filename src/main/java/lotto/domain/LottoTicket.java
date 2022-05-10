package lotto.domain;

import lotto.exceptions.DuplicateLottoNumberException;
import lotto.exceptions.InvalidLottoCountException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoTicket = lottoNumbers;
    }

    private void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoCountException();
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new DuplicateLottoNumberException();
        }
    }

    public List<String> getLottoNumbers() {
        List<String> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoTicket) {
            lottoNumbers.add(lottoNumber.toString());
        }
        return lottoNumbers;
    }

    public List<LottoNumber> getLottoTicket() {
        return this.lottoTicket;
    }


    public Integer getMatchResult(WinningLotto winningLotto) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(lottoTicket);
        lottoNumbers.addAll(winningLotto.getLottoTicket());
        return lottoTicket.size() + winningLotto.getLottoTicket().size() - lottoNumbers.size();
    }

    public boolean isMatchedBonus(WinningLotto winningLotto) {
        return lottoTicket.contains(winningLotto.getBonusNumber());
    }

    public boolean hasLottoNumber(LottoNumber lottoNumber) {
        return lottoTicket.contains(lottoNumber);
    }
}
