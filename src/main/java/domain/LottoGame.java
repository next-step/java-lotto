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

    // 로또 번호 생성 시작
    public void run() {
        getAutoLottoNumber();
        prvLottoNumber = InputVeiw.inputPrvLottoNumber();
    }

    // 로또번호 자동생성
    private void getAutoLottoNumber() {
        for (int i = 0; i < numofLotto; i++) {
            lotto.add(new LottoNumber());
            Collections.sort(lotto.get(i).getElement());
        }

        ResultView.printLottoNumber(lotto);
    }

    // 가격을 갯수로 변환
    public int substringPricetoNumber(int price) {
        String priceString = String.valueOf(price);
        return Integer.parseInt(priceString.substring(0, priceString.length() - SUBSTR_RANGE));
    }

    // 당첨 결과 확인 함수 호출
    public void showResult() {
        LottoResult.getNumberOfMatch(lotto, prvLottoNumber, price);
    }
}
