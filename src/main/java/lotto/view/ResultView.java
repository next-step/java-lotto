package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printPurchaseLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.getLottos().stream().forEach(lotto -> printLottoNumbers(lotto.getNumbers()));
    }

    private static void printLottoNumbers(List<LottoNumber> numbers) {
        List<String> numbersStringList = numbers.stream().map(LottoNumber::getLottoNumber).map(String::valueOf).collect(Collectors.toList());
        System.out.println("[" + String.join(", ", numbersStringList) + "]");
    }

    public static void printWinners(LottoGame lottoGame) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        printWinnersByAward(Award.FOURTH, lottoGame);
        printWinnersByAward(Award.THIRD, lottoGame);
        printWinnersByAward(Award.SECOND, lottoGame);
        printWinnersByAward(Award.FIRST, lottoGame);

    }

    private static void printWinnersByAward(Award award, LottoGame lottoGame) {
        System.out.println(award.getMatchNumbers() + "개 일치 (" + award.getAmount() + "원)- " + lottoGame.countWinners(award));
    }

    public static void printYield(LottoGame lottoGame, int amount) {
        double yield = getYield(lottoGame, amount);
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static double getYield(LottoGame lottoGame, int amount) {
        return (double) (Award.FOURTH.getAmount() * lottoGame.countWinners(Award.FOURTH) +
                Award.THIRD.getAmount() * lottoGame.countWinners(Award.THIRD) +
                Award.SECOND.getAmount() * lottoGame.countWinners(Award.SECOND) +
                Award.FIRST.getAmount() * lottoGame.countWinners(Award.FIRST)) / (double) amount;
    }
}
