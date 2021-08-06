package step3.view;

import step3.domain.Lottos;
import step3.lottoPlace.LastWeekLotto;
import step3.lottoPlace.LottoPlace;
import step3.lottoPlace.LottoPlaceChecker;

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

    public static void showResult(LastWeekLotto lastWeekLotto, Lottos lottos) {
        LottoPlaceChecker lottoPlaceChecker = LottoPlaceChecker.of(lastWeekLotto);
        List<LottoPlace> lottoPlaces = lottoPlaceChecker.getLottoPlace(lottos);
        BigDecimal winnerRate = lottoPlaceChecker.calculateWinnerRate(lottoPlaces, lottos.getTotalCost());

        showResult();

        showForth(lottoPlaces);
        showThird(lottoPlaces);
        showSecond(lottoPlaces);
        showFirst(lottoPlaces);

        showWinnerRate(winnerRate);
    }

    private static void showWinnerRate(BigDecimal winnerRate) {
        System.out.println("총 수익률은 " + winnerRate + "입니다. (기준 1)");
    }

    private static void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void showForth(List<LottoPlace> lottoPlaces) {
        long forth = lottoPlaces.stream().filter(lottoPlace -> lottoPlace == LottoPlace.FORTH).count();
        System.out.println(LottoPlace.FORTH.getCorrectNum() + "개 일치 (" + LottoPlace.FORTH.getPrice() + "원) - " + forth + "개");
    }

    private static void showThird(List<LottoPlace> lottoPlaces) {
        long third = lottoPlaces.stream().filter(lottoPlace -> lottoPlace == LottoPlace.THIRD).count();
        System.out.println(LottoPlace.THIRD.getCorrectNum() + "개 일치 (" + LottoPlace.THIRD.getPrice() + "원) - " + third + "개");
    }

    private static void showSecond(List<LottoPlace> lottoPlaces) {
        long second = lottoPlaces.stream().filter(lottoPlace -> lottoPlace == LottoPlace.SECOND).count();
        System.out.println(LottoPlace.SECOND.getCorrectNum() + "개 일치 (" + LottoPlace.SECOND.getPrice() + "원) - " + second + "개");
    }

    private static void showFirst(List<LottoPlace> lottoPlaces) {
        long first = lottoPlaces.stream().filter(lottoPlace -> lottoPlace == LottoPlace.FIRST).count();
        System.out.println(LottoPlace.FIRST.getCorrectNum()+ "개 일치 (" + LottoPlace.FIRST.getPrice() + "원) - " + first + "개");
    }
}
