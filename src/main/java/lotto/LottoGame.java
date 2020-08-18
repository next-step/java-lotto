package lotto;

import common.StringResources;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultNumber;
import lotto.domain.RandomLottoCreator;
import lotto.ui.ResultView;

import java.util.List;
import java.util.NoSuchElementException;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final int money;
    private List<LottoNumber> lottoNumberList;

    public LottoGame(int money) {
        this.money = money;
    }

    public void buy() {

        ResultView.print((money / LOTTO_PRICE) + StringResources.MSG_BUY_QUANTITY);

        this.lottoNumberList = RandomLottoCreator.createLottoList(money);

        for (LottoNumber lottoNumber : lottoNumberList) {
            ResultView.print(lottoNumber.toString());
        }
    }

    public void winning(LottoResultNumber lottoResultNumber) {

        verifyLottoNumberListIsNull();

        ResultView.print(StringResources.MSG_WINNING_STATUS);
        ResultView.print(StringResources.LINE_SEPARATOR);

        LottoResult lottoResult = new LottoResult(money, lottoNumberList, lottoResultNumber);
        ResultView.printLottoResult(lottoResult);
        ResultView.printLottoEarningsRate(lottoResult);
    }

    private void verifyLottoNumberListIsNull() {
        if (lottoNumberList == null) {
            throw new NoSuchElementException(StringResources.ERR_NO_LOTTO_LIST);
        }
    }
}
