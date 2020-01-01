package lotto.io;

import lotto.domain.Order;

import java.util.List;

public class OutputView {

    public static void showOrderStatus(Order order) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d장를 구매했습니다.", order.getSelfNumberCount(), order.getAutoNumberCount()));
    }

    public static void showLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(lottoNumber -> System.out.println("[" + lottoNumber + "]"));
    }

    public static void showLottoResult(int rankMatchCount, int rankReward, int matchCount) {
        System.out.println(String.format("%d개 일치 (%d원) - %d개"));
    }
}
