package view;

import domain.Lotto;
import domain.LottoStatistics;
import util.LottoSeller;
import domain.LottoResult;
import util.LottoManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LottoOutputView {
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }

    public static void printLottoResult(LottoStatistics statistics) {
        System.out.println(statistics.serializeStatistics());
    }
}
