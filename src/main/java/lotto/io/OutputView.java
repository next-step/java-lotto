package lotto.io;

import lotto.domain.Order;

public class OutputView {

    public static void showLottoCount(Order order) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d장를 구매했습니다.", order.getSelfNumberCount(), order.getAutoNumberCount()));
    }

    public static void showLottoNumber(String lottoNumbers) {
        System.out.println("[" + lottoNumbers + "]");
    }
}
