package step2.domain;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    static final int MIN_OF_LOTTO_NUMBER = 1;
    static final int MAX_OF_LOTTO_NUMBER = 45;
    static final int NUM_OF_LOTTO_NUMBER = 6;
    static ArrayList<Integer> lottoNumberList = new ArrayList<>();
    static LottoNumber lottoNumber


    public Lotto() {
        makeLottoNumberList();
    }

    public ArrayList<Integer> issueLotto() {
        ArrayList<Integer> lotto = new ArrayList<>();
        Collections.shuffle(lottoNumberList);
        for (int i = 0; i < NUM_OF_LOTTO_NUMBER; i++) {
            lotto.add(lottoNumberList.get(i));
        }
        printIssuedLottoNumber(lotto);
        return lotto;
    }

    private void printIssuedLottoNumber(ArrayList lotto) {
        System.out.println(lotto);
    }

    public ArrayList<Integer> makeLottoNumberList() {
        for (int i = MIN_OF_LOTTO_NUMBER; i <= MAX_OF_LOTTO_NUMBER; i++) {
            lottoNumber = new LottoNumber(i);
            lottoNumberList.add(lottoNumber.getNumber());
        }
        return lottoNumberList;
    }
}
