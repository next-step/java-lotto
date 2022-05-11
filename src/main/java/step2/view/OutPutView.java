package step2.view;

import step2.domain.LottoRank;
import step2.domain.PurchaseMoney;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class OutPutView {

    private static final String LINE_BREAK = "\n";
    private static final String END = "[END]";
    private static final String RESULT_LINE = "\n" + "당첨통계" + "---------------\n";
    private static final String PROFIT_MESSAGE = "이득입니다.";
    private static final String LOSS_MESSAGE = "손해입니다.";

    public OutPutView() {
    }

    public void showPurchaseCount(PurchaseMoney purchaseMoney) {
        int manualCount = purchaseMoney.calculateManualPurchaseCount();
        int autoCount = purchaseMoney.calculateAutoPurchaseCount();
        show(String.format("수동으로 %d 개, 자동으로 %d 개를 구매했습니다.", manualCount, autoCount));
    }

    public void showGameResult(Map<LottoRank, Integer> gameResult) {
        Map<LottoRank, Integer> rankCountMap = initBaseMap();
        rankCountMap.putAll(gameResult);
        show(createOutputMessage(rankCountMap));
    }

    private Map<LottoRank, Integer> initBaseMap() {
        Map<LottoRank, Integer> rankCountMap = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCountMap.put(rank, 0);
        }
        return rankCountMap;
    }

    private String createOutputMessage(Map<LottoRank, Integer> rankCountMap) {
        return rankCountMap.entrySet()
                .stream()
                .map(this::createString)
                .collect(Collectors.joining(LINE_BREAK));
    }

    private String createString(Map.Entry<LottoRank, Integer> entry) {
        LottoRank rank = entry.getKey();
        Integer count = entry.getValue();
        return rank.toString() + " - " + count + "개";
    }

    public void showReturnRate(double returnRate, boolean isProfitable) {
        String profitMessage = createProfitMessage(isProfitable);
        String output = String.format("총 수익률은 %f 입니다. -> %s", returnRate, profitMessage);
        show(output);
    }

    private String createProfitMessage(boolean isProfitable) {
        if (isProfitable) {
            return PROFIT_MESSAGE;
        }
        return LOSS_MESSAGE;
    }

    public void showResultLine() {
        show(RESULT_LINE);
    }

    public void showEnd() {
        show(END);
    }

    public void show(String output) {
        out.println(output);
    }

}
