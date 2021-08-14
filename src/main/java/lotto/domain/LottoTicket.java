package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final LottoNumber lottoNumber = new LottoNumber();
    private LottoRank lottoRank;
    private int collectNumber = 0;

    public LottoTicket() {
        lottoRank = LottoRank.RANK_7TH;
    }

    public void checkResult(final List<Integer> winningNumbers) {
        List<Integer> numbers = lottoNumber.getLottoNumbers();
        for (Integer lottoNumber : numbers) {
            isCollectNumber(winningNumbers, lottoNumber);
        }
        setRank();
    }

    private void setRank() {
        this.lottoRank = lottoRank.findRank(collectNumber);
    }

    private void isCollectNumber(final List<Integer> winningNumbers, final int number) {
        if (winningNumbers.contains(number)) {
            increaseCollectNumber();
        }
    }

    public void increaseCollectNumber() {
        this.collectNumber++;
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }

    public String getNumberString() {
        return lottoNumber.getNumberString();
    }
}
