package step2.view;

import step2.domain.*;
import step2.lottoPlace.LottoPlace;
import step2.lottoPlace.LottoPlaceChecker;

import java.math.BigDecimal;
import java.util.List;

public class ResultView {
    public static void showCurrent(Lottos lottos) {
        showLottoCount(lottos);
        showLottoNums(lottos);
    }

    private static void showLottoCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
    }

    private static void showLottoNums(Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.getLottos().get(i));
        }
        System.out.println();
    }

    public static void showResult(List<Integer> lastWeekLottoNum, Lottos lottos) {
        LottoPlaceChecker lottoPlaceChecker = LottoPlaceChecker.of(lastWeekLottoNum);
        List<LottoPlace> lottoPlaces = lottoPlaceChecker.getLottoPlace(lottos);
        showResult();

        showForth(lottoPlaces);
        showThird(lottoPlaces);
        showSecond(lottoPlaces);
        showFirst(lottoPlaces);

        showWinnerRate(lottoPlaces);
    }

    private static void showWinnerRate(List<LottoPlace> lottoPlaces) {
        BigDecimal winnerRate = calculateWinnerRate(lottoPlaces);
        System.out.println("총 수익률은 " + winnerRate + "입니다. (기준 1)");
    }

    private static void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void showForth(List<LottoPlace> lottoPlaces) {
        long forth = lottoPlaces.stream().filter(lottoPlace -> lottoPlace == LottoPlace.FORTH).count();
        System.out.println("3개 일치 (5000원) - " + forth + "개");
    }

    private static void showThird(List<LottoPlace> lottoPlaces) {
        long third = lottoPlaces.stream().filter(lottoPlace -> lottoPlace == LottoPlace.THIRD).count();
        System.out.println("4개 일치 (50000원) - " + third + "개");
    }

    private static void showSecond(List<LottoPlace> lottoPlaces) {
        long second = lottoPlaces.stream().filter(lottoPlace -> lottoPlace == LottoPlace.SECOND).count();
        System.out.println("5개 일치 (1500000원) - " + second + "개");
    }

    private static void showFirst(List<LottoPlace> lottoPlaces) {
        long first = lottoPlaces.stream().filter(lottoPlace -> lottoPlace == LottoPlace.FIRST).count();
        System.out.println("6개 일치 (2000000000원) - " + first + "개");
    }

    private static BigDecimal calculateWinnerRate(List<LottoPlace> lottoPlaces) {
        int sum = calculateTotalPrice(lottoPlaces);
        long payed = (long) lottoPlaces.size() * Shop.LOTTO_PRICE;
        return BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(payed));
    }

    private static int calculateTotalPrice(List<LottoPlace> lottoPlaces) {
        return lottoPlaces.stream().mapToInt(LottoPlace::getPrice).sum();
    }
}
