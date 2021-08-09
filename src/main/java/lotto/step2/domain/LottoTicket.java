package lotto.step2.domain;

import java.util.List;

public class LottoTicket {

    private List<Integer> lottoNumber;
    private int matchCount;

    public LottoTicket() {
        this.lottoNumber = LottoMachine.mixLottoNumbers();
    }

    public int matchWinningNumber(WinningNumber winningNumber) {
        for (int num : lottoNumber) {
            isContainNumber(winningNumber, num);
        }

        return matchCount;
    }

    private void isContainNumber(WinningNumber winningNumber, int num) {
        if (winningNumber.getWinningNumbers().contains(num)) {
            matchCount++;
        }
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
