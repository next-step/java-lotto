package lotto.domain;

import lotto.strategy.AutoLottoStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket() {}

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void generateLottoNumbers(AutoLottoStrategy autoLottoStrategy) {
        lottoNumbers = autoLottoStrategy.generateLottoNumbers();
    }

    public int matchLottoNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for(Integer lottoNumber : winningNumbers) {
            if(lottoNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
