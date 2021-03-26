package lotto.view;

import java.util.List;
import lotto.dto.LottoOrderedDto;

public class ResultView {
    public static void printLottoResult(LottoOrderedDto lottoOrderedDto) {
        System.out.printf("%d개를 구매했습니다.\n", lottoOrderedDto.getPurchasedLottoCount());

        List<String> lottoNumberList = lottoOrderedDto.getLottoNumberList();
        lottoNumberList.forEach(System.out::println);
    }

    public static void printLottoStats() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }
}
