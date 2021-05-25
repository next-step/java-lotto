package lotto.domain;

import lotto.common.WinningType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = new ArrayList<>(new LottoTicketGenerator().generate());
    }

    public LottoTicket(String lottoNumbersText) {
        this.lottoNumbers = new ArrayList<>(new LottoTicketGenerator().generate(lottoNumbersText));
    }

    public List<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    public WinningType getWinningType(LottoTicket winningLottoTicket, int bonusNumber) {
        int matchCount = 0;
        for (LottoNumber winningLottoNumber : winningLottoTicket.getLottoTicket()) {
            matchCount += addCount(contains(winningLottoNumber), matchCount);
        }

        return WinningType.of(matchCount, isMatchBonus(bonusNumber));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private int addCount(boolean isContains, int matchCount) {
        if (isContains) {
            return 1;
        }
        return 0;
    }

    private boolean isMatchBonus(int bonusNumber) {
        if (this.lottoNumbers.contains(new LottoNumber(bonusNumber))) {
            return true;
        }
        return false;
    }

    public String getString() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            lottoNumbers.add(lottoNumber.of());
        }
        return lottoNumbers.toString();
    }
}
