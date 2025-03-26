package lotto;

import java.util.List;
public class ResultView {

    public static void printCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumber(List<LottoRow> lottoRowList) {
        for (LottoRow lottoRow : lottoRowList) {
            System.out.println(lottoRow.getLottoNumbers());
        }
    }
}
