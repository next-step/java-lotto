package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;
    private LottoRank lottoRank;
    private int collectNumber = 0;

    public LottoTicket(LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        lottoNumbers = new LottoNumbers(lottoNumberSelectPolicy);
        lottoRank = LottoRank.FAIL;
    }

    public void checkResult(final List<Integer> winningNumbers) {
        List<Integer> numbers = lottoNumbers.getLottoNumbers();
        for (Integer lottoNumber : numbers) {
            isCollectNumber(winningNumbers, lottoNumber);
        }
        findResultRank();
    }

    private void findResultRank() {
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

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }
}
