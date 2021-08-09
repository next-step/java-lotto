package step2.domain;

import step2.util.LastWinningLottoNumberChecker;

import java.util.ArrayList;

public class LottoMachine {
    static int numOfLotto;
    static Lotto lotto = new Lotto();
    static ArrayList<ArrayList> issuedLottolist = new ArrayList<>();


    public ArrayList<ArrayList> run(int numOfLotto) {
        getLottoList(numOfLotto);

        return issuedLottolist;
    }

    public ArrayList<ArrayList> getLottoList(int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            issuedLottolist.add(lotto.issueLotto());
        }
        return issuedLottolist;
    }
}
