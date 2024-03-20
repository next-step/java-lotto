package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        (new LottoNumbers()).validate(numbers);
        this.numbers = numbers;
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this(lottoNumbers.auto());
    }

    public LottoPrize getPrize(LottoTicket winLottoTicket) {
        int matchCount = 0;
        for (Integer number : winLottoTicket.numbers) {
            matchCount += count(number);
        }
        return LottoPrize.lookup(matchCount);
    }

    private int count(Integer number) {
        int matchCount = 0;
        if (numbers.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

    public List<Integer> get() {
        return this.numbers;
    }

}
