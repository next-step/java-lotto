package study.step2.view;

import static study.step2.utils.MessageUtil.LOTTO_COUNT_MESSAGE;
import static study.step2.utils.MessageUtil.LOTTO_RESULT_MESSAGE;

import java.util.Comparator;
import java.util.Map;
import study.step2.domain.LottoNumber;
import study.step2.domain.LottoResult;
import study.step2.domain.Lottos;
import study.step2.domain.Rank;

public class ResultView {

  private ResultView() {
  }

  public static void printLottoCount(int lottoCount) {
    System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
  }

  public static void printLottos(Lottos lottos) {
    lottos.getLottos().forEach(lotto -> printLottoNumbers(lotto.getLottoNumbers()));

    printNextLine();
  }

  private static void printLottoNumbers(LottoNumber lottoNumber) {
    System.out.println(lottoNumber.toString());
  }

  public static void printNextLine() {
    System.out.println();
  }

  public static void printLottoResultMessage() {
    System.out.println(LOTTO_RESULT_MESSAGE);
    System.out.println("---------");
  }

  public static void printLottoResult(LottoResult result) {
    Map<Rank, Integer> rankMap = result.getRankMap();

    rankMap.keySet().stream().sorted(Comparator.comparingInt(Rank::getMatchCount))
        .map(rank -> rank.getMatchCount()
        + "개 일치 ("
        + rank.getPrizeMoney()
        + ")- "
        + rankMap.get(rank)
        + "개")
        .forEach(System.out::println);
  }

  public static void printYield(LottoResult result, int money) {
    System.out.println(String.format("총 수익률은 %.2f 입니다.", result.calculateYield(money)));
  }

}
