package step3.domain;

import java.util.ArrayList;

public class Customer {
    private static final LottoMachine lottoMachine = new LottoMachine();

    public ArrayList<ArrayList<Integer>> buyLotto(int numOfLotto) {
        return lottoMachine.issue(numOfLotto);
    }

    public Integer calculateMatchedLottoNumbers() {

    }
}
