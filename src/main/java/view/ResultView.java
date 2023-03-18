package view;

import java.util.List;

import java.util.Map;

import domain.FirstPlaceLotto;
import domain.Lotto;
import domain.LottoProfit;
import domain.LottoRank;

import domain.Lottos;
import domain.type.LottoRankResult;

public class ResultView {

    public static void printBuyManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void printManualLottoInput() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printBuyManualAndAutoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
    }

    public static void printLottoResult(Lottos lottos, FirstPlaceLotto firstPlaceLotto) {
        Map<LottoRankResult, Integer> map = lottos.getLottoRankCount(firstPlaceLotto);

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + map.get(LottoRankResult.FIFTH) + "개");
        System.out
                .println("4개 일치 (50000원)- " + map.get(LottoRankResult.FOURTH) + "개");
        System.out
                .println("5개 일치 (1500000원)- " + map.get(LottoRankResult.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- "
                + map.get(LottoRankResult.SECOND) + "개");
        System.out.println(
                "6개 일치 (2000000000원)- " + map.get(LottoRankResult.FIRST) + "개");
        System.out.println("총 수익률은 " + LottoProfit.getProfitRate(lottos, firstPlaceLotto) + "입니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> {
            printLotto(lotto);
        });
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers().toString());
    }

    public static void printLotto(FirstPlaceLotto lotto) {
        System.out.println(lotto.getLottoNumbers().toString());
    }
}