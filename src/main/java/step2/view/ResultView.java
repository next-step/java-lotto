package step2.view;

import step2.lotto.Lotto;
import step2.lotto.LottoPrize;
import step2.lotto.Lottos;
import step2.lotto.result.ResultStatistic;

public class ResultView {

    public void print(String string) {
        System.out.println(string);
    }

    public void printHowManyTicketClientBought(Lottos lottos) {
        String lottoReceipt = getLottoReceipt(lottos);
        print(lottoReceipt);
    }

    public void printResultStatistic(ResultStatistic resultStatistic) {
        String result = getResult(resultStatistic);
        print(result);
    }

    private String getLottoReceipt(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개를 구매했습니다", lottos.count()));
        sb.append("\n");
        sb.append(lottos.toString());
        return sb.toString();
    }

    private String getResult(ResultStatistic resultStatistic) {
        StringBuilder sb = new StringBuilder();
        createTitle(sb);
        createBody(sb, resultStatistic);
        createFooter(sb, resultStatistic);
        return sb.toString();
    }

    private void createTitle(StringBuilder sb) {
        sb.append("당첨 통계");
        sb.append("\n");
        sb.append("---------");
        sb.append("\n");
    }

    private void createBody(StringBuilder sb, ResultStatistic resultStatistic) {

        long countOfFirst = resultStatistic.countOfMatches(Lotto.COUNT_OF_MATCHES_FIRST);
        long countOfSecond = resultStatistic.countOfMatches(Lotto.COUNT_OF_MATCHES_SECOND);
        long countOfThird = resultStatistic.countOfMatches(Lotto.COUNT_OF_MATCHES_THIRD);
        long countOfFourth = resultStatistic.countOfMatches(Lotto.COUNT_OF_MATCHES_FOURTH);

        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Lotto.COUNT_OF_MATCHES_FOURTH, LottoPrize.getLottoPrize(Lotto.COUNT_OF_MATCHES_FOURTH).getPrizeMoney(), countOfFourth));
        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Lotto.COUNT_OF_MATCHES_THIRD, LottoPrize.getLottoPrize(Lotto.COUNT_OF_MATCHES_THIRD).getPrizeMoney(), countOfThird));
        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Lotto.COUNT_OF_MATCHES_SECOND, LottoPrize.getLottoPrize(Lotto.COUNT_OF_MATCHES_SECOND).getPrizeMoney(), countOfSecond));
        sb.append(String.format("%d개 일치 (%d원)- %d개", Lotto.COUNT_OF_MATCHES_FIRST, LottoPrize.getLottoPrize(Lotto.COUNT_OF_MATCHES_FIRST).getPrizeMoney(), countOfFirst));
        sb.append("\n");
    }

    private void createFooter(StringBuilder sb, ResultStatistic resultStatistic) {
        sb.append(String.format("총 수익률은 %.2f 입니다", resultStatistic.getTotalRevenueRate()));
    }
}
