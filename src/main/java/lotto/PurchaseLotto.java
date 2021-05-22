package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    //private int purchasedLottoCount;
    private LottoNumber lottoNumber;
    private LottoNumberList lottoNumberList;
    private LastWonLottoNumber lastWonLottoNumber;
    //private static InputAmount inputAmount;

    public int availablePurchaseLottoCount(int amount) {
        return amount/LOTTO_PRICE;
    }

    public void purchaseLotto(int lottoCount) {
        lottoNumberList = new LottoNumberList();
        for (int i=0; i<lottoCount; i++) {
            lottoNumber = new LottoNumber();
            lottoNumberList.appendLottoNumber(lottoNumber);
        }
    }

    public LottoNumberList getLottoNumberList() {
        return this.lottoNumberList;
    }

    public LastWonLottoNumber getLastWonLottoNumbers() {
        return this.lastWonLottoNumber;
    }

    public void checkWinOrLose(String lastWonLottoNumbers) {
        setLastWonLottoNumbers(lastWonLottoNumbers);
    }

    public void setLastWonLottoNumbers(String lastWonLottoNumbers) {
        this.lastWonLottoNumber = new LastWonLottoNumber(lastWonLottoNumbers);
    }
}
