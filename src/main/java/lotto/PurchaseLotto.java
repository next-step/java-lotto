package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private int purchasedLottoCount;
    private LottoNumber lottoNumber;
    private List<LottoNumber> lottoNumberList;
    private List<Integer> lastWonLottoNumbers;
    //private static InputAmount inputAmount;

    public int availablePurchaseLottoCount(int amount) {
        return amount/LOTTO_PRICE;
    }

    public void purchaseLottos(int lottoCount) {
        lottoNumberList = new ArrayList<LottoNumber>();
        for (int i=0; i<lottoCount; i++) {
            lottoNumber = new LottoNumber();
            lottoNumberList.add(lottoNumber);
        }
    }

    public List<LottoNumber> getLottoNumberList() {
        return this.lottoNumberList;
    }

    public List<Integer> getLastWonLottoNumbers() {
        return this.lastWonLottoNumbers;
    }

    public void checkWinOrLose(String lastWonLottoNumbers) {
        setLastWonLottoNumbers(lastWonLottoNumbers);

    }

    public void setLastWonLottoNumbers(String lastWonLottoNumbers) {
        this.lastWonLottoNumbers = new ArrayList<Integer>();
        String[] tempLastWonLottoNumbers = lastWonLottoNumbers.split(",");
        for(int i=0; i<tempLastWonLottoNumbers.length; i++) {
            this.lastWonLottoNumbers.add(Integer.parseInt(tempLastWonLottoNumbers[i]));
        }
    }
}
