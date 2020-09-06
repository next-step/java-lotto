package AutoLotto.view;

import AutoLotto.domain.lotto.BuzzLotto;
import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.UserLottos;
import AutoLotto.domain.money.UserMoney;
import AutoLotto.domain.play.Rank;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView(){}

    public static void printPlayResult(int budget, List<Integer> buzzLotto) {
     printLottosCount(budget); //inputView
     printUserLottos(UserLottos.buyLottosWith(budget));
     printEmptyLine();
     printBuzzLottoEach(buzzLotto);      //inputView
     printEmptyLine();
     printPlayLottoResult(budget, buzzLotto);
    }

    private static void printLottosCount(int budget) {
        System.out.println(budget);
        System.out.println(UserLottos.countLottosBy(budget) + "개를 구매했습니다.");
    }

    //UserLottos.buyLottosWith(budget) 생성된 Lotto의 list 가져와 돌면서 출력
    private static void printUserLottos(List<UserLotto> userLottos) {

    }

    private static void printEmptyLine() {
        System.out.println("");
    }

    private static void printBuzzLottoEach(List<Integer> buzzLotto) {
        System.out.println(buzzLotto.stream()
                .map(number -> number.toString())
                .collect(Collectors.joining(", ")));
    }
    //EmptyLine

    private static void printPlayLottoResult(int budget, List<Integer> buzzLotto) {
        System.out.println("당첨 통계\n---------");
        //countMatchAll()로 나온  matchCountList에 3이 나온 횟수, 4가 나온 횟수.. %2f
        System.out.printf( "3개 일치 (%d원)- %d개", Rank.FOURTH.rankMoney,0);
        System.out.printf( "4개 일치 (%d원)- %d개", Rank.THIRD.rankMoney,0);
        System.out.printf( "5개 일치 (%d원)- %d개", Rank.SECOND.rankMoney,0);
        System.out.printf( "6개 일치 (%d원)- %d개", Rank.FIRST.rankMoney,0);
        System.out.printf("총 수익률은 %d 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)",
                0, "손해||이득");
    }


}
