package step4.view;

import step4.lotto.Lotto;
import step4.lotto.Lottos;
import step4.lotto.Rank;
import step4.lotto.result.ResultStatistic;

public class ResultView {

    public void print(String string) {
        System.out.println(string);
    }

    public void printHowManyTicketClientBought(Lottos manualLottos, Lottos automaticLottos) {
        String lottoReceipt = getLottoReceipt(manualLottos, automaticLottos);
        print(lottoReceipt);
    }

    public void printResultStatistic(ResultStatistic resultStatistic) {
        String result = getResult(resultStatistic);
        print(result);
    }

    private String getLottoReceipt(Lottos manualLottos, Lottos automaticLottos) {
        Lottos lottos = Lottos.empty();
        lottos.addAll(manualLottos);
        lottos.addAll(automaticLottos);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다", manualLottos.count(), automaticLottos.count()));
        sb.append("\n");
        sb.append(lottos);
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

        long countOfFirst = resultStatistic.countOfRank(Rank.FIRST);
        long countOfSecond = resultStatistic.countOfRank(Rank.SECOND);
        long countOfThird = resultStatistic.countOfRank(Rank.THIRD);
        long countOfFourth = resultStatistic.countOfRank(Rank.FOURTH);
        long countOfFifth = resultStatistic.countOfRank(Rank.FIFTH);

        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Rank.FIFTH.getCountOfMatch(), Rank.valueOf(Rank.FIFTH.getCountOfMatch(), false).getPrizeMoney(), countOfFifth));
        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Rank.FOURTH.getCountOfMatch(), Rank.valueOf(Rank.FOURTH.getCountOfMatch(), false).getPrizeMoney(), countOfFourth));
        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Rank.THIRD.getCountOfMatch(), Rank.valueOf(Rank.THIRD.getCountOfMatch(), false).getPrizeMoney(), countOfThird));
        sb.append(String.format("%d개 일치, 보너스볼 일치(%d원)- %d개\n", Rank.SECOND.getCountOfMatch(), Rank.valueOf(Rank.SECOND.getCountOfMatch(), true).getPrizeMoney(), countOfSecond));
        sb.append(String.format("%d개 일치 (%d원)- %d개", Rank.FIRST.getCountOfMatch(), Rank.valueOf(Rank.FIRST.getCountOfMatch(), false).getPrizeMoney(), countOfFirst));
        sb.append("\n");
    }

    private void createFooter(StringBuilder sb, ResultStatistic resultStatistic) {
        sb.append(String.format("총 수익률은 %.2f 입니다", resultStatistic.getTotalRevenueRate()));
    }
}
