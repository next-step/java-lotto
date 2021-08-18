package step2;

public class ResultView {

  final static String LEFT_BRACKET = "[";
  final static String RIGHT_BRACKET = "]";
  final static String COMMA = ",";
  final static String BLANK_SPACE = " ";

  public void printPurchasedLotto(Lotto lotto) {

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
