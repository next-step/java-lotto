package lotto;

import java.util.ArrayList;
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

}
