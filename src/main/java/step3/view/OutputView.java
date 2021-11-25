package step3.view;

import static java.lang.String.format;

import java.util.List;
import java.util.Map;
import step3.model.Lotto;
import step3.model.LottoBundle;
import step3.model.LottoNumber;
import step3.model.LottoPrize;
import step3.model.LottoWin;
import step3.model.Reward;

public class OutputView {

    private static final String BUNDLE_COUNT_MESSAGE = "%d 개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String LINE = "-------------";
    private static final String REWARD_COUNT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String YIELD_MESSAGE = "총 수익률은 %.2f입니다. ";
    private static final int YIELD_LOWER_LIMIT = 1;
    private static final String YIELD_LOW_MESSAGE = format("(기준이 %d이기 때문에 결과적으로 손해라는 의미임)", YIELD_LOWER_LIMIT);

    public static void printLottoBundle(LottoBundle lottoBundle) {
        List<Lotto> lottoList = lottoBundle.getLottoList();
        System.out.printf(BUNDLE_COUNT_MESSAGE, lottoList.size());
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        StringBuilder sb = getLottoPrintFormat(lottoNumbers);
        System.out.println(sb);
    }

    private static StringBuilder getLottoPrintFormat(List<LottoNumber> lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            sb.append(lottoNumber);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb;
    }

    public static void printLottoPrize(LottoPrize lottoPrize) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(LINE);
        printLottoWin(lottoPrize.getLottoWin());
        printYield(lottoPrize.totalYield());
    }

    private static void printLottoWin(LottoWin lottoWin) {
        Map<Reward, Long> rewardMap = lottoWin.getRewardMap();
        rewardMap.keySet().stream()
            .filter(Reward::isWin)
            .sorted()
            .forEach(reward -> printReward(reward, rewardMap.get(reward)));
    }

    private static void printReward(Reward reward, long winCount) {
        System.out.printf(REWARD_COUNT_MESSAGE, reward.getMatchCount(), reward.getRewardMoney().won(), winCount);
    }

    private static void printYield(double yield) {
        System.out.printf(YIELD_MESSAGE, yield);
        if (yield < YIELD_LOWER_LIMIT) {
            System.out.println(YIELD_LOW_MESSAGE);
        }
    }

    private OutputView() {
    }
}
