package lotto;

import common.StringResources;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultNumber;
import lotto.ui.ResultView;

import java.util.List;

public class LottoGame {

    private final int money;
    private final List<LottoNumber> lottoNumberList;

    public LottoGame(int money, List<LottoNumber> lottoNumberList) {
        this.money = money;
        this.lottoNumberList = lottoNumberList;
    }

    public void buy() {

        ResultView.print((money / 1000) + StringResources.MSG_BUY_QUANTITY);

        for (LottoNumber lottoNumber : lottoNumberList) {
            ResultView.print(lottoNumber.toString());
        }
    }

    public void winning(LottoResultNumber lottoResultNumber) {

        ResultView.print(StringResources.MSG_WINNING_STATUS);
        ResultView.print(StringResources.LINE_SEPARATOR);

        LottoResult lottoResult = new LottoResult(money, lottoNumberList, lottoResultNumber);
        ResultView.printLottoResult(lottoResult);
        ResultView.printLottoEarningsRate(lottoResult);
    }
}
