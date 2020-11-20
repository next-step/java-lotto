package lotto.views;

public class ResultView {

  private static final String NUM_LOTTO_MESSAGE = "개를 구매했습니다.";
  private static final String SCORING_OPENING_MESSAGE = "당첨 통계";
  private static final String SPLIT_LINE_MESSAGE = "----------------";

  private ResultView() {
  }

  public static void printNumLotto(int numLotto) {
    System.out.print(numLotto);
    System.out.println(NUM_LOTTO_MESSAGE);
  }

  public static void printLottoInfo(String lotto) {
    System.out.print(lotto);
  }

  public static void printStatisticsOpening() {
    System.out.println(SCORING_OPENING_MESSAGE);
    System.out.println(SPLIT_LINE_MESSAGE);
  }
}
