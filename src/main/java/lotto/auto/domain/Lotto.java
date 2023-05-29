package lotto.auto.domain;

import lotto.auto.vo.EntireNumber;
import lotto.auto.vo.WinNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumber;

    public Lotto() {
        this.lottoNumber = new EntireNumber().shuffleAndPickNumber();
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumber;
    }

    public Win checkWin(WinNumber winNumbers) {
        int matchNumber = 0;
        for (Integer winNumber : winNumbers.getWinNumbers()) {
            matchNumber += isMatch(winNumber);
        }
        return Win.getWin(matchNumber);
    };

    private int isMatch(Integer win) {
        if(lottoNumber.contains(win)) {
            return 1;
        };
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
