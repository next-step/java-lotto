package lotto.view;

import java.util.List;
import lotto.controller.LottoController;
import lotto.model.History;
import lotto.model.Product;
import lotto.service.LottoService;

public final class OutputTable {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String BUY_THING_MESSAGE = "%d개를 구입하였습니다.\n";
  private static final String LAST_WEEK_AWARD_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String STATISTICS_MESSAGE = "당첨 통계";
  private static final String UNDER_BAR = "_________";
  private static final String HISTORY_MESSAGE = "%d개 일치 (%d원)- %d개\n";
  private static final String YIELD_MESSAGE = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)";
  private static final String WIN_MESSAGE = "이득";
  private static final String LOSE_MESSAGE = "손해";

  private OutputTable() {
  }

  public static void main(String[] args) {
    LottoController controller = new LottoController(new LottoService());
    controller.run();
  }

  public static void inputPurchaseAmount() {
    System.out.println(PURCHASE_AMOUNT_MESSAGE);
  }

  public static void buyThings(Integer productCount) {
    System.out.printf(BUY_THING_MESSAGE, productCount);
  }

  public static void printProductInfos(List<Product> products) {
    for (Product product : products) {
      System.out.println(product);
    }
  }

  public static void lastWeekAwardNumber() {
    System.out.println();
    System.out.println(LAST_WEEK_AWARD_NUMBER_MESSAGE);
  }

  public static void resultStatisticsMessage() {
    System.out.println(STATISTICS_MESSAGE);
    System.out.println(UNDER_BAR);
  }

  public static void resultStatistics(List<History> histories) {
    for (History history : histories) {
      System.out.printf(HISTORY_MESSAGE, history.getGrade().getExpectNumber(),
          history.getGrade().getAwardPrice(), history.getCount());
    }
  }

  public static void printYield(double yield, boolean isStandard) {
    System.out.printf(YIELD_MESSAGE, yield,
        standardMessage(isStandard));
  }

  private static String standardMessage(boolean isStandard) {
    if (isStandard) {
      return WIN_MESSAGE;
    }
    return LOSE_MESSAGE;
  }
}
