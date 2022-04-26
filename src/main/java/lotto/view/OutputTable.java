package lotto.view;

import java.util.List;
import lotto.controller.LottoController;
import lotto.model.Product;
import lotto.model.Statistics;
import lotto.service.LottoService;

public final class OutputTable {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String BUY_THING_MESSAGE = "%d개를 구입하였습니다.\n";
  private static final String LAST_WEEK_AWARD_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String STATISTICS_MESSAGE = "당첨 통계";
  private static final String UNDER_BAR = "_________";

  private OutputTable() {
  }

  public static void main(String[] args) {
    LottoController lottoController = new LottoController(new LottoService());
    lottoController.run();
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
    System.out.println(LAST_WEEK_AWARD_NUMBER_MESSAGE);
  }

  public static void resultStatistics() {
    System.out.println(STATISTICS_MESSAGE);
    System.out.println(UNDER_BAR);
  }

  public static void printStatistics(List<Statistics> statistics) {
    for (Statistics statistic : statistics) {
      System.out.println(statistic);
    }
  }
}
