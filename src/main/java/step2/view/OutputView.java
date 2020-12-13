package step2.view;

import step2.domain.UserLotto;

import java.util.List;

public class OutputView {

  public static void printLottoCount(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void printLottoList(List<UserLotto> userLottoList) {
    for (UserLotto lotto : userLottoList) {
      System.out.println(lotto.toString());
    }
  }
}
