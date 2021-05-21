package lotto.ui;

import lotto.dto.OrderedInfos;

public class OutputView {

  private static final String ORDERED_N_GAMES_FORMAT = "%d개를 구매했습니다.";

  private OutputView() {}

  public static void displayOrderedGames(OrderedInfos orderedInfos) {
    System.out.println(String.format(ORDERED_N_GAMES_FORMAT, orderedInfos.orderedCount()));
    System.out.println(orderedInfos.toString());
  }


}
