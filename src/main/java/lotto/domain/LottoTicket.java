package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Integer> lottoNumbers;
    private LottoRank lottoRank ;
    private int collectNumber = 0;

    public LottoTicket() {
        lottoNumbers = LottoNumberSelector.selectNumbers();
        lottoRank = LottoRank.RANK_7TH;
    }

    public void checkResult(final List<Integer> winningNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
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

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public String getNumberString() {
        List<String> numbers = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            numbers.add(lottoNumber.toString());
        }
        return "[" + String.join(", ", numbers) + "]";
    }
}
