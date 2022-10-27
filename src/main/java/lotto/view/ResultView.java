package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.PurchaseInfo;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "수동으로 {manualAmount}장 자동으로 {autoAmount}를 구매했습니다.";
    private static final String RANK_INIT_MESSAGE = "당첨 통계\n-------";
    private static final String RANK_MESSAGE = "{countOfMatch}개 일치 ({winningMoney}원)- {amount}개";
    private static final String YIELD_MESSAGE = "총 수익률은 {yield}입니다.";

    public static void printPurchaseAmount(PurchaseInfo purchaseInfo) {
        System.out.println(PURCHASE_AMOUNT_MESSAGE
                .replace("{manualAmount}", String.valueOf(purchaseInfo.getManualAmount()))
                .replace("{autoAmount}", String.valueOf(purchaseInfo.getAutoAmount()))
        );
    }

    public static void printLottoNumbers(LottoTickets lottoTickets) {
        lottoTickets.getLottoList().forEach(l -> System.out.println(l.getLottoNumbers()));
        System.out.println();
    }

    public static void printRanks(List<Rank> rankList) {
        System.out.println(RANK_INIT_MESSAGE);
        Arrays.stream(Rank.values())
                .collect(Collectors.toList())
                .forEach(r -> System.out.println(RANK_MESSAGE
                        .replace("{countOfMatch}", String.valueOf(r.getCountOfMatch()))
                        .replace("{winningMoney}", String.valueOf(r.getWinningMoney()))
                        .replace("{amount}", String.valueOf(Collections.frequency(rankList, r))))
                );
    }

    public static void printYield(BigDecimal yield) {
        System.out.println(YIELD_MESSAGE.replace("{yield}", String.valueOf(yield)));
    }

}
