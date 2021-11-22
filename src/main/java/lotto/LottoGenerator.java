package lotto;

import lotto.strategy.LotteryStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTERY_NUMBER_COUNT = 45;

    private LottoNumbers lottoNumbers;
    private final LotteryStrategy lotteryStrategy;

    public LottoGenerator(LotteryStrategy lotteryStrategy) {
        this.lotteryStrategy = lotteryStrategy;
        initLottoNumbers();
    }

    public LottoNumbers generateLottoNumber() {
        return this.lotteryStrategy.draw(this.lottoNumbers);
    }

    private void initLottoNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= LOTTERY_NUMBER_COUNT; i++) {
            numbers.add(new LottoNumber(i));
        }

        this.lottoNumbers = new LottoNumbers(numbers);
    }
}
