package study.step2.view;

import static study.step2.utils.MessageUtil.LOTTO_RESULT_MESSAGE;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import study.step2.domain.LottoNumber;
import study.step2.domain.LottoResult;
import study.step2.domain.Lottos;
import study.step2.domain.Rank;

public class ResultView {

  private static final String lottoResultString = "%d개 일치 (%d원)- %d개";
  private static final String lottoCountResultString = "수동으로 %d장, 자동으로 %d장 구매했습니다.";
  private static final String yieldString = "총 수익률은 %.2f 입니다.";

  private ResultView() {
  }

  public static void printLottoCount(int manualLottosSize, int lottoCount) {
    System.out.println(String.format(lottoCountResultString, manualLottosSize, lottoCount));
  }

  public static void printLottos(Lottos lottos) {
    lottos.getLottos().forEach(lotto -> printLottoNumbers(lotto.getLottoNumbers()));

    printNextLine();
  }

  private static void printLottoNumbers(Set<LottoNumber> lottoNumbers) {
    System.out.println(lottoNumbers.toString());
  }

  public static void printNextLine() {
    System.out.println();
  }

  public static void printLottoResultMessage() {
    System.out.println();
    System.out.println(LOTTO_RESULT_MESSAGE);
    System.out.println("---------");
  }

  public static void printLottoResult(LottoResult result) {
    Map<Rank, Integer> rankMap = result.getRankMap();

    rankMap.remove(Rank.MISS);

    rankMap.keySet().stream()
        .sorted(Comparator.comparingInt(Rank::getMatchCount))
        .forEach(rank -> System.out.println(String.format(lottoResultString, rank.getMatchCount(), rank.getPrizeMoney(), rankMap.get(rank))));
  }

  public static void printYield(LottoResult result, int money) {
    System.out.println(String.format(yieldString, result.calculateYield(money)));
  }

}
