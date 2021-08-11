package lotto.step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private List<Integer> lottoNumber;
    private List<LottoNumber> lottoNumbers;
    private int matchCount;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers= lottoNumbers;
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
