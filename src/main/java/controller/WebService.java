package controller;

import domain.Lotto;
import domain.LottoGameResult;
import domain.LottoMoney;
import domain.LottoProfit;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WebService {

    public static LottoMoney getLottoMoney(String input) {
        return new LottoMoney(Integer.parseInt(input));
    }

    public static List<Lotto> getUserLottos(String[] inputManualLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (String input : inputManualLotto) {
            lottos.add(new Lotto(InputView.splitStringToLotto(input)));
        }
        return lottos;
    }

    public static List<String> getResults(LottoGameResult lottoGameResult) {
        List<String> results = new ArrayList<>();
        for (LottoProfit profit : LottoProfit.values()) {
            results.add(profit.getNumberOfMatch() + "개 일치 (" + profit.getPrizeMoney() + "원) - "
                    + lottoGameResult.getWinningCountOfResult(profit) +"개");
        }
        return results;
    }


}
