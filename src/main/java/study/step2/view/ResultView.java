package study.step2.view;

import static study.step2.utils.MessageUtil.LOTTO_COUNT_MESSAGE;
import static study.step2.utils.MessageUtil.LOTTO_RESULT_MESSAGE;

import java.util.List;
import study.step2.domain.Lottos;

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

  private static void printLottoNumbers(List<Integer> lottoNumbers) {
    System.out.println(lottoNumbers.toString());
  }

  public static void printNextLine() {
    System.out.println();
  }

  public static void printLottoResultMessage() {
    System.out.println(LOTTO_RESULT_MESSAGE);
    System.out.println("---------");
  }

  public static void printLottoMatchCount() {
    System.out.println(LOTTO_RESULT_MESSAGE);
    System.out.println("---------");
  }

}
