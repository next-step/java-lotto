package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberLottery {
    private static final int MAX_LOTTERY_NUMBER_COUNT = 6;
    private List<Integer> lottoNumbers = LottoNumbers.getLottoNumbers();

    public List<LotteryNumbers> getLottoNumbersList(int count) {
        List<LotteryNumbers> lotteryNumbersList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotteryNumbersList.add(getLotteryNumbers());
        }

        return lotteryNumbersList;
    }

    private LotteryNumbers getLotteryNumbers() {
        Collections.shuffle(lottoNumbers);

        LotteryNumbers lotteryNumbers = new LotteryNumbers();
        for (int i = 0; i < MAX_LOTTERY_NUMBER_COUNT; i ++) {
            lotteryNumbers.addLottoNumber(lottoNumbers.get(i));
        }

        sortLotteryNumbers(lotteryNumbers);

        return lotteryNumbers;
    }

    private void sortLotteryNumbers(LotteryNumbers lotteryNumbers) {
        Collections.sort(lotteryNumbers.getLottoNumberList());
    }
}
