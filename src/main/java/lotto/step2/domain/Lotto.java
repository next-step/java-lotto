package lotto.step2.domain;

import java.util.ArrayList;

public class Lotto {

    private ArrayList<ArrayList<Integer>> lotto;

    public Lotto() {
        this.lotto = new ArrayList<ArrayList<Integer>>();
    }

    public ArrayList buyLotto(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 1000원입니다.");
        }
        int lottoSize = price / 1000;
        for (int i=0; i< lottoSize; i++) {
            lotto.add(LottoMachine.mixLottoNumbers());
        }
        return lotto;
    }
}
