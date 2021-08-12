package step3.domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoMachine {
    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<>();
    static final private ArrayList<Integer> lottoNumberCandidateList = new ArrayList<>();

    public LottoMachine() {
        getLottoNumberCandidateArray();
    }

    public ArrayList<ArrayList<Integer>> issue(int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            lottoList.add(getRandomNumberLotto());
        }
        return lottoList;
    }

    public ArrayList<Integer> getRandomNumberLotto() {
        ArrayList<Integer> lotto = new ArrayList<>();
        Collections.shuffle(lottoNumberCandidateList);
        for (int i = 0; i < 6; i++) {
            lotto.add(new Lotto(lottoNumberCandidateList.get(i)).getNumber());
        }
        return lotto;
    }

    private void getLottoNumberCandidateArray() {
        for (int i = 1; i <= 45; i++) {
            lottoNumberCandidateList.add(i);
        }
    }
}
