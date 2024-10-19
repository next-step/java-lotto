package lotto;

import java.util.List;

public class LottoNumberList {
    List<OneTimeRoundLottoNumberList> lottoNumberList;



    public LottoNumberList(List<OneTimeRoundLottoNumberList> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public void add(OneTimeRoundLottoNumberList oneTimeRoundLottoNumberList) {
        lottoNumberList.add(oneTimeRoundLottoNumberList);
    }

    public void printLottoList() {
        for (OneTimeRoundLottoNumberList numberList : lottoNumberList) {
            System.out.println(numberList);
        }
    }

    public void runWinner(LottoWinner lottoWinner) {
        for (OneTimeRoundLottoNumberList numberList : lottoNumberList) {
            numberList.runWinner(lottoWinner);
        }
    }
}
