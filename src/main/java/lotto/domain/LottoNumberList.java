package lotto.domain;

import lotto.ui.PrintView;

import java.util.List;

public class LottoNumberList {
    private List<OneTimeRoundLottoNumberList> lottoNumberList;



    public LottoNumberList(List<OneTimeRoundLottoNumberList> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }


    public void add(OneTimeRoundLottoNumberList oneTimeRoundLottoNumberList) {
        lottoNumberList.add(oneTimeRoundLottoNumberList);
    }

    public void printLottoList() {
        PrintView.printLottoList(lottoNumberList);
    }

    public void recordWinningCount(LottoWinner lottoWinner) {
        for (OneTimeRoundLottoNumberList numberList : lottoNumberList) {
            int matchingCount = lottoWinner.diffLottoAndWinningLotto(numberList.convertLottoNumberList());
            lottoWinner.recordWinningCount(matchingCount);
        }
    }
}
