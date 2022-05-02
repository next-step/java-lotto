package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.Ranks;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        StringBuilder builder = new StringBuilder();
        lottoTickets.forEach(lottoTicket ->
                builder.append(lottoTicket.getLottoNumbers()).append("\n"));
        System.out.println(builder);
    }

    public void printResult(List<Integer> matchNumbers, int money) {
        System.out.println("\n당첨 통계\n--------");
        Map<Rank, Integer> resultMap = Ranks.getGroupByMap(matchNumbers);
        printPrize(resultMap);
        printProfitRatio(resultMap, money);
    }

    private void printProfitRatio(Map<Rank, Integer> resultMap, int money) {
        Integer reduce = resultMap.entrySet()
                .stream()
                .map(e -> e.getKey().getPrize() * e.getValue())
                .reduce(0, Integer::sum);
        double profitRatio = (double) reduce / money;
        String ratioString = this.getRatioString(profitRatio);
        System.out.println(ratioString);
    }

    private String getRatioString(double profitRatio) {
        StringBuilder builder = new StringBuilder();
        builder.append("총 수익률은 ");
        String ratioString = getFormat(profitRatio);
        builder.append(ratioString);
        if (profitRatio > 1) {
            builder.append("입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
            return builder.toString();
        }
        builder.append("입니다.(기준이 1이기 대문에 결과적으로 손해라는 의미임)");

        return builder.toString();
    }

    private String getFormat(double profitRatio) {
        return String.format("%.2f", profitRatio);
    }

    private void printPrize(Map<Rank, Integer> resultMap) {
        String resultMapString = this.getResultString(resultMap);
        System.out.println(resultMapString);
    }

    private String getResultString(Map<Rank, Integer> resultMap) {
        StringBuilder builder = new StringBuilder();
        resultMap.forEach((rank, count) -> {
            builder.append(rank.getMatchNumberCount());
            builder.append("개 일치 ");
            builder.append(rank.getPrize() * count);
            builder.append("원 - ");
            builder.append(count);
            builder.append("개");
            builder.append("\n");
        });
        return builder.toString();
    }
}
