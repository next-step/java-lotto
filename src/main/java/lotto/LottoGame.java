package lotto;

import common.StringResources;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultNumber;
import lotto.domain.RandomLottoCreator;
import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final List<LottoNumber> lottoNumberList = new ArrayList<>();
    private final int principal;
    private int manualLottoCount;
    private int balance;

    public LottoGame(int principal) {
        this.principal = principal;
        this.balance = principal;
    }

    public void setManualLottoCount(int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
        verifyManualLotto();
    }

    public void buyManual(List<LottoNumber> manualLottoNumber) {
        lottoNumberList.addAll(manualLottoNumber);
        balance -= LOTTO_PRICE * manualLottoCount;
    }

    private void verifyManualLotto() {
        if (balance < 0) {
            throw new IllegalArgumentException(StringResources.ERR_MANUAL_COUNT_OVER_PRINCIPAL);
        }
    }

    public void buyAuto() {

        int manualCount = (principal - balance) / LOTTO_PRICE;
        int autoCount = balance / LOTTO_PRICE;

        ResultView.printLottoQuantity(manualCount, autoCount);

        List<LottoNumber> lottoNumbers = RandomLottoCreator.createLottoList(balance);

        for (LottoNumber lottoNumber : lottoNumbers) {
            lottoNumberList.add(lottoNumber);
            ResultView.print(lottoNumber.toString());
        }
    }

    public void winning(LottoResultNumber lottoResultNumber) {

        verifyLottoNumberListIsNull();

        ResultView.print(StringResources.MSG_WINNING_STATUS);
        ResultView.print(StringResources.LINE_SEPARATOR);

        LottoResult lottoResult = new LottoResult(principal, lottoNumberList, lottoResultNumber);
        ResultView.printLottoResult(lottoResult);
        ResultView.printLottoEarningsRate(lottoResult);
    }

    private void verifyLottoNumberListIsNull() {
        if (lottoNumberList.size() == 0) {
            throw new NoSuchElementException(StringResources.ERR_NO_LOTTO_LIST);
        }
    }
}
