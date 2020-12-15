package lotto.ui;

import lotto.LottoCollection;
import lotto.domain.LottoResult;

import java.util.Set;

public class ResultView {
    public static void printLottoNumberList(LottoCollection lottoCollection) {
        int lottoCount = lottoCollection.getLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> lottoNumbers = lottoCollection.getLottoNumbers(i);
            System.out.println(lottoNumbers);
        }
    }

    public static void printStatistics(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", 1);
        System.out.printf("4개 일치 (50000원)- %d개\n", 0);
        System.out.printf("5개 일치 (1500000원)- %d개\n", 0);
        System.out.printf("6개 일치 (2000000000원)- %d개\n", 0);
    }
}
