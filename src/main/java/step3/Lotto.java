package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lotto {

    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;

    List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public static List<Integer> lotteryStatics(Set<Lotto> purchasedLottos, List<Integer> winningNumbers) {
        List<Integer> resultMatching = new ArrayList<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            resultMatching.add(LottoLottery.matchWinningNumbers(purchasedLotto, winningNumbers));
        }
        return resultMatching;
    }

    // 통계를 내기위해 Map에 N개 일치하는(Key) 로또가 몇장인지 (Value) 저장
    public static Map<Integer, Integer> giveStatistic(List<Integer> resultMatching) {
        LottoLottery.generateBasicStatistic();
        for (int i = 1; i < LottoGenerator.WINNING_NUMBERS_LENGTH + 1; i++) {
            LottoLottery.summaryMatching(resultMatching, i);
        }
        return LottoLottery.statisticResult;
    }
}