package lotto.domain;

import lotto.strategy.LottoStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static LottoTicket generateLottoNumbers(LottoStrategy lottoStrategy) {
        List<Integer> generatedNumbers = lottoStrategy.generateLottoNumbers();
        return new LottoTicket(generatedNumbers);
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

    public String formatLottoNumbers() {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
