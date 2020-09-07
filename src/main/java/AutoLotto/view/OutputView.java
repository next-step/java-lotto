package AutoLotto.view;

import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.UserLottos;
import AutoLotto.domain.play.PlayLotto;
import AutoLotto.domain.play.Rank;

import static AutoLotto.utils.Constants.*;

import java.util.List;

public class OutputView {

    private OutputView(){}


    public static void printLottosCount(int money) {
        System.out.printf(SAY_COUNT_USERLOTTOS, UserLottos.countLottosBy(money));
    }

    //UserLottos.buyLottosWith(budget) 생성된 Lotto의 list 가져와 돌면서 출력
    public static void printUserLottos(List<UserLotto> userLottos) {
        System.out.println("lottos list");

    }

    public static void printEmptyLine() {
        System.out.println("");
    }
//
//    public static void printBuzzNumberEach(List<LottoNumber> buzzLotto) {
//        System.out.println(buzzLotto.stream()
//                .map(number -> number.toString())
//                .collect(Collectors.joining(", ")));
//    }


    public static void printPlayLottoResult(PlayLotto playLotto) {
        System.out.println(SAY_PLAY_RESULT_START);
        //countMatchAll()로 나온  matchCountList에 3이 나온 횟수, 4가 나온 횟수.. %2f
        System.out.printf( "3개 일치 (%d원)- %d개\n", Rank.FOURTH.rankMoney,0);
        System.out.printf( "4개 일치 (%d원)- %d개\n", Rank.THIRD.rankMoney,0);
        System.out.printf( "5개 일치 (%d원)- %d개\n", Rank.SECOND.rankMoney,0);
        System.out.printf( "6개 일치 (%d원)- %d개\n", Rank.FIRST.rankMoney,0);
        System.out.printf(SAY_PLAY_PROFIT, playLotto.makePlayProfitRateBy(), "손해||이득");
    }


}
