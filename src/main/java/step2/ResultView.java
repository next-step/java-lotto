package step2;

import step2.model.Lotto;
import step2.model.Lottos;

public class ResultView {

  final static String LEFT_BRACKET = "[";
  final static String RIGHT_BRACKET = "]";
  final static String COMMA = ",";
  final static String BLANK_SPACE = " ";

  public void printPurchasedLotto(Lottos lottos) {

    System.out.println(lottos.getLottosSize() + "개를 구매했습니다.");

    for (int i = 0; i < lottos.getLottosSize(); i++) {
      printLotto(lottos.getLotto(i));
    }
  }

  private void printLotto(Lotto lotto) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(LEFT_BRACKET);
    for (Integer integer : lotto.getLottoNumbers()) {
      stringBuilder.append(integer);
      stringBuilder.append(COMMA + BLANK_SPACE);
    }
    stringBuilder.delete(stringBuilder.lastIndexOf(COMMA), stringBuilder.length());
    stringBuilder.append(RIGHT_BRACKET);

    System.out.println(stringBuilder);
  }
}
