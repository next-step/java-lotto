package lotto.domain;

import lotto.common.WinningType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> LOTTO_NUMBERS;

    public LottoTicket() {
        this.LOTTO_NUMBERS = new ArrayList<>(new LottoTicketGenerator().generate());
    }

    public LottoTicket(String lottoNumbersText) {
        this.LOTTO_NUMBERS = new ArrayList<>(new LottoTicketGenerator().generate(lottoNumbersText));
    }

    public List<LottoNumber> getLottoTicket() {
        return Collections.unmodifiableList(this.LOTTO_NUMBERS);
    }

    public WinningType getWinningType(LottoTicket winningLottoTicket, int bonusNumber) {
        int matchCount = 0;
        for (LottoNumber winningLottoNumber : winningLottoTicket.getLottoTicket()) {
            matchCount += addCount(contains(winningLottoNumber), matchCount);
        }

        return WinningType.of(matchCount, isMatchBonus(bonusNumber));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.LOTTO_NUMBERS.contains(lottoNumber);
    }

    private int addCount(boolean isContains, int matchCount) {
        if (isContains) {
            return 1;
        }
        return 0;
    }

    private boolean isMatchBonus(int bonusNumber) {
        if (this.LOTTO_NUMBERS.contains(new LottoNumber(bonusNumber))) {
            return true;
        }
        return false;
    }

    public String getString() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : this.LOTTO_NUMBERS) {
            lottoNumbers.add(lottoNumber.of());
        }
        return lottoNumbers.toString();
    }
}
