package src.view;

import src.domain.Lotto;
import src.domain.Lottos;
import src.domain.MatchStatus;
import src.domain.Place;

import java.util.Comparator;
import java.util.List;

public final class ResultView {

    private ResultView() {
    }

    public static void printPurchaseLottoGameCount(int lottoGameCount) {
        System.out.println(lottoGameCount + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> values = lottos.values();
        for (Lotto lotto: values) {
            System.out.println(lotto.toString());
        }
    }

    public static void printMatchResult(MatchStatus matchStatus, double profitRate) {
        printMatchStatus(matchStatus);
        printProfitRate(profitRate);
    }

    private static void printMatchStatus(MatchStatus matchStatus) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<Place> places = Place.winningPlaces();
        places.sort(Comparator.comparing(Place::amount));
        for (Place place : places) {
            Integer matchedCount = matchStatus.status().getOrDefault(place, 0);
            printWinningPlaceResult(place, matchedCount);
        }
    }

    private static void printWinningPlaceResult(Place place, int matchedCount) {
        String print = String.format("%d개 일치 (%f.0원) - %d개", place.matchCount(), place.amount(), matchedCount);
        if (place == Place.SECOND_PLACE) {
            print = String.format("%d개 일치, 보너스 볼 일치(%f.0원) - %d개", place.matchCount(), place.amount(), matchedCount);
        }
        System.out.println(print);
    }

    private static void printProfitRate(double profitRate) {
        System.out.print("총 수익률은 " + profitRate + "입니다.");
        if (profitRate < 1.0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
