package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private static final String BUY_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String COMMA_SEPARATOR = ",";
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    private static final String NEW_LINE = "\n";
    private static final String RANK_REWARD_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String SECOND_RANK_REWARD_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private Lottos lottos;
    private LottoCount lottoCount;
    private StringBuilder lottosView;

    public LottoResult(Lottos lottos, LottoCount lottoCount) {
        this.lottos = lottos;
        this.lottoCount = lottoCount;
    }

    public void reportLottos() {
        lottosView = new StringBuilder();
        lottosView.append(getLottoBuyMessage());
        lottosView.append(getCreateLottoNumber());
    }

    private String getLottoBuyMessage() {
        return String.format(BUY_MESSAGE, lottoCount.manualCount(), lottoCount.autoCount());
    }

    public StringBuilder getCreateLottoNumber() {
        StringBuilder message = new StringBuilder();
        message.append(NEW_LINE);
        for (Lotto lotto : lottos.getLottos()) {
            message.append(START_BRACKET);
            message.append(getLottoNumbers(lotto.getLotto()));
            message.append(END_BRACKET);
            message.append(NEW_LINE);
        }
        return message;
    }

    public String getLottoNumbers(List<LottoNumber> lotto) {
        return lotto.stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.number()))
                .collect(Collectors.joining(COMMA_SEPARATOR));
    }

    public StringBuilder getLottosView() {
        return lottosView;
    }

    public StringBuilder getStatisticsView(List<MatchResult> matchCounts) {
        LottoStatistic lottoStatistic = new LottoStatistic(matchCounts, lottoCount);
        StringBuilder statisticView = new StringBuilder();
        Arrays.asList(Rank.values()).stream()
                .filter(rank -> !rank.isNothing())
                .forEach(rank -> statisticView.append(getRankRewardMessage(lottoStatistic, rank)));
        statisticView.append(getProfitMessage(lottoStatistic));
        return statisticView;
    }

    private String getRankRewardMessage(LottoStatistic lottoStatistic, Rank rank) {
        return String.format(getRankRewardMessage(rank), rank.getMatchCount(), rank.getMoney(), lottoStatistic.rankCount().getOrDefault(rank, 0));
    }

    private String getRankRewardMessage(Rank rank) {
        if (rank.isSecond()) {
            return SECOND_RANK_REWARD_MESSAGE;
        }
        return RANK_REWARD_MESSAGE;
    }

    private String getProfitMessage(LottoStatistic lottoStatistic) {
        return String.format(PROFIT_RATE_MESSAGE, lottoStatistic.calculateProfitRate());
    }
}
