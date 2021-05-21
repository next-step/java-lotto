package study.lotto;

import java.util.*;

public class LottoPaper {
    private MarkedLottoNumbers markedLottoNumbers;

    public LottoPaper() {
        this.markedLottoNumbers = new MarkedLottoNumbers();
    }

    public LottoPaper(List<Integer> numbers) {
        this.markedLottoNumbers = new MarkedLottoNumbers(numbers);
    }


    public MarkedLottoNumbers markedLottoNumbers() {
        return markedLottoNumbers;
    }
}
