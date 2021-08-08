package step2.domain;

import java.util.ArrayList;

public class LottoMachine {
    static int numOfLotto;
    static LastWinningLottoNumberChecker lastWinningLottoNumberChecker;
    static Lotto lotto = new Lotto();
    static int[] lastWinningLottoNumberArray;
    static ArrayList<ArrayList> issuedLottolist = new ArrayList<>();

    public LottoMachine(int numOfLotto, String lastWinningLottoNum) {
        this.numOfLotto = numOfLotto;
        lastWinningLottoNumberChecker = new LastWinningLottoNumberChecker(lastWinningLottoNum);
        lastWinningLottoNumberArray = lastWinningLottoNumberChecker.getLottoWinningNumberArray();

    }

    public void getLottoList() {
        for (int i = 0; i < numOfLotto; i++) {
            issuedLottolist.add(lotto.issueLotto());
        }
    }

}
