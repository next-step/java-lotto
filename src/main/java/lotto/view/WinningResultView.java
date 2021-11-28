package lotto.view;

import lotto.domain.Rank;
import lotto.domain.dto.LottoResultDto;

public class WinningResultView {

    private static final int DEFAULT_VALUE = 0;

    private WinningResultView() {
    }

    public static void resultView(LottoResultDto dto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank key : Rank.valuesFilterNoPrizeMoney()) {
            resultPrint(dto, key);
        }
        System.out.println(String.format("총 수익률은 %.2f 입니다.", dto.getRate()));
    }

    private static void resultPrint(LottoResultDto dto, Rank key) {
        if (key == Rank.SECOND) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개"
                , key.getCount(), key.getPrizeMoney(), dto.getResultRank().getOrDefault(key, DEFAULT_VALUE)));
            return;
        }

        System.out.println(String.format("%d개 일치 (%d원) - %d개"
            , key.getCount(), key.getPrizeMoney(), dto.getResultRank().getOrDefault(key, DEFAULT_VALUE)));
    }

}
