package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int MIN_COUNT_TO_PRIZE = 3;

    private List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getSortedLottoNumbers(){
        Collections.sort(this.lottoNumbers);
        return this.lottoNumbers;
    }

    public int countWinningNumbers(List<Integer> lastWinningNumbers) {
        List<Integer> winningsNumber = lottoNumbers
                .stream().filter(element -> lastWinningNumbers.contains(element)).collect(Collectors.toList());

        if(winningsNumber.size() >= MIN_COUNT_TO_PRIZE){
            return winningsNumber.size();
        }

        return 0;
    }

}
