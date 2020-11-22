package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Rank;

import java.util.List;
import java.util.TreeMap;

public class ResultView {

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        System.out.println(lottoNumbers.size()+"개를 구매했습니다.");
        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getValue().toString());
        }
    }

    public static void printWinningStatistics(TreeMap<Integer, List<Rank>> ranks, double rate) {
        ranks.forEach((key, value) -> {
            System.out.println(value.get(0).getDescription() + value.size());
        });

        System.out.println("총 수익률은 "+rate+"입니다.");
    }
}
