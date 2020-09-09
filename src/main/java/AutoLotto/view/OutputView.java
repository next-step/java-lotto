package AutoLotto.view;

import AutoLotto.domain.lotto.LottoNumber;
import AutoLotto.domain.lotto.UserLotto;
import AutoLotto.domain.lotto.UserLottos;
import AutoLotto.domain.money.Money;
import AutoLotto.domain.play.PlayLotto;
import AutoLotto.domain.play.PlayLottoResult;
import AutoLotto.domain.play.Rank;

import static AutoLotto.utils.Constants.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView(){}

    public static void printLottosCount(int money) {
        System.out.printf(SAY_COUNT_USERLOTTOS, UserLottos.countLottosBy(money));
    }

    public static void printUserLottos(List<UserLotto> userLottos) {
        userLottos.stream()
                .forEach(userLotto -> printLottoAscending(userLotto));
    }

    private static void printLottoAscending(UserLotto userLotto) {
        String lottoAscending  = userLotto.getUserLotto().stream()
                            .map(LottoNumber::getLottoNumber)
                            .sorted()
                            .map(number -> number.toString())
                            .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX));
        System.out.println(lottoAscending);
    }

    public static void printEmptyLine() {
        System.out.println(EMPTY_LINE);
    }


    public static void printPlayLottoResult(PlayLottoResult playLottoResult) {
        System.out.println(SAY_PLAY_RESULT_START);
        Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount >= PRIZE_GET_MATCH_COUNT_MIN)
                .collect(Collectors.toList())
                .forEach(rank ->
                        System.out.printf(rank.matchCount + SAY_PLAY_RESULT_BY_RANK,
                                rank.rankMoney,
                                getPlayMatchResult(playLottoResult, rank)));
    }

    private static int getPlayMatchResult(PlayLottoResult playLottoResult, Rank rank) {
        return playLottoResult.getCountByRank(rank);
    }

    public static void printPlayProfitResult(int money, PlayLottoResult playLottoResult) {
        Money budget = new Money(money);
        System.out.printf(SAY_PLAY_PROFIT, budget.makePlayProfitRateBy(playLottoResult), budget.isPlayPlusProfitBy(playLottoResult));
    }



}
