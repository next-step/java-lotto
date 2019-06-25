package domain;

import view.InputVeiw;
import view.ResultView;

import java.util.ArrayList;
import java.util.Collections;

public class LottoGame {
    private final static int SUBSTR_RANGE = 3;


    private ArrayList<LottoNumber> lotto;
    private static int[] prvLottoNumber = null;
    private int numofLotto;
    private int price;

    public LottoGame(int inputPrice) {
        this.price = inputPrice;
        this.numofLotto = substringPricetoNumber(inputPrice);
        lotto = new ArrayList<LottoNumber>();
    }

    public void run() {
        getAutoLottoNumber();
        prvLottoNumber = InputVeiw.inputPrvLottoNumber();
    }

    private void getAutoLottoNumber() {
        for (int i = 0; i < numofLotto; i++) {
            lotto.add(new LottoNumber());
            Collections.sort(lotto.get(i).getElement());
        }

        ResultView.printLottoNumber(lotto);
    }

    private int substringPricetoNumber(int price) {
        String priceString = String.valueOf(price);
        return Integer.parseInt(priceString.substring(0, priceString.length() - SUBSTR_RANGE));
    }

    public void showResult() {
        LottoResult.getNumberOfMatch(lotto, prvLottoNumber, price);

    }

}
