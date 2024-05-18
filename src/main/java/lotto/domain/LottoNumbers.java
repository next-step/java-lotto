package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers(Integer... lottoNumbers){
        this(List.of(lottoNumbers));
    }

    public LottoNumbers(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> lottoNumbers(){
        return lottoNumbers;
    }

    public int matchCount(List<Integer> lastWinningNumbers){
        return (int) lastWinningNumbers.stream()
            .filter(lottoNumbers::contains)
            .count();
    }
}
