package AutoLotto.view;

import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.UserLottos;
import AutoLotto.domain.money.Money;
import AutoLotto.domain.play.PlayLotto;
import AutoLotto.domain.play.PlayLottoResult;
import AutoLotto.domain.play.Rank;

import static AutoLotto.utils.Constants.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView(){}

    public static void printLottosCount(int money) {
        System.out.printf(SAY_COUNT_USERLOTTOS, UserLottos.countLottosBy(money));
    }

    //UserLottos.buyLottosWith(budget) 생성된 Lotto의 list 가져와 돌면서 출력
    //하나의 Lottto 안에서는 sorted 오름차순 필요
    public static void printUserLottos(List<UserLotto> userLottos) {
        userLottos.stream()
                .forEach(userLotto -> printLottoAscending(userLotto));
    }

    private static void printLottoAscending(UserLotto userLotto) {
        String lottoAscending  = userLotto.getUserLotto().stream()
                            .map(LottoNumber::getLottoNumber)
                            .sorted()
                            .map(number -> number.toString())
                            .collect(Collectors.joining(", ","[","]"));
        System.out.println(lottoAscending);
    }

    public static void printEmptyLine() {
        System.out.println("");
    }


    public static void printPlayLottoResult(PlayLottoResult playLottoResult, PlayLotto playLotto) {
        System.out.println(SAY_PLAY_RESULT_START);
        //countMatchAll()로 나온  matchCountList에 3이 나온 횟수, 4가 나온 횟수.. %2f
        System.out.printf( Rank.FOURTH.matchCount +"개 일치 (%d원)- %d개\n", Rank.FOURTH.rankMoney, getPlayMatchResult(playLottoResult, playLotto, Rank.FOURTH));
        System.out.printf( Rank.THIRD.matchCount +"개 일치 (%d원)- %d개\n", Rank.THIRD.rankMoney, getPlayMatchResult(playLottoResult, playLotto, Rank.THIRD));
        System.out.printf( Rank.SECOND.matchCount +"개 일치 (%d원)- %d개\n", Rank.SECOND.rankMoney, getPlayMatchResult(playLottoResult, playLotto, Rank.SECOND));
        System.out.printf( Rank.FIRST.matchCount +"개 일치 (%d원)- %d개\n", Rank.FIRST.rankMoney,getPlayMatchResult(playLottoResult, playLotto, Rank.FIRST));
    }

    private static int getPlayMatchResult(PlayLottoResult playLottoResult, PlayLotto playLotto, Rank rank) {
        playLotto.countMatchAll(playLottoResult);
        return playLottoResult.getCountByRank(rank);
    }

    public static void printPlayProfitResult(int money, PlayLottoResult playLottoResult) {
        Money budget = new Money(money);
        System.out.printf(SAY_PLAY_PROFIT, budget.makePlayProfitRateBy(playLottoResult), "손해||이득");
    }


}
