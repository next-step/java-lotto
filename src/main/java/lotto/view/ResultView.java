package lotto.view;

import lotto.domain.LottoSheet;

import java.util.List;

public class ResultView {
    public static void printLottoSheetCount(int lottoSheetCount) {
        System.out.println(lottoSheetCount + "개를 구매했습니다.");
    }

    public static void printLottoSheets(List<LottoSheet> lottoSheets) {
        lottoSheets.forEach(lottoSheet -> System.out.println(lottoSheet.getLottoNumbers().toString()));
        System.out.println();
    }
}
