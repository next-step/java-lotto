package lotto.view;

import lotto.domain.Rank;
import lotto.domain.dto.ResultDto;

public class WinningResultView {

    private static final int DEFAULT_VALUE = 0;
    private static final int MINIMUM_COUNT = 3;

    private WinningResultView() {
    }

    public static void resultView(ResultDto dto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank key : Rank.values()) {
            if (key.getCount() >= MINIMUM_COUNT) {
                System.out.println(String.format("%d개 일치 (%d원) - %d개", key.getCount(), key.getMoney(), dto.getResultRank().getOrDefault(key, DEFAULT_VALUE)));
            }
        }
        System.out.println(String.format("총 수익률은 %.2f 입니다.", dto.getYield()));
    }

}
