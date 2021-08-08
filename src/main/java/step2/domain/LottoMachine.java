package step2.domain;

import java.util.ArrayList;

public class LottoMachine {
    static int numOfLotto;
    static String lastWinningLottoNum;
    static LastWinningLottoNumberChecker lastWinningLottoNumberChecker;
    static Lotto lotto = new Lotto();
    static ArrayList<Integer> lastWinningLottoNumberArray;
    static ArrayList<ArrayList> issuedLottolist = new ArrayList<>();

    public LottoMachine(int numOfLotto, String lastWinningLottoNum) {
        this.numOfLotto = numOfLotto;
        this.lastWinningLottoNum = lastWinningLottoNum;

    }

    public ArrayList<ArrayList> run() {
        getLottoList();
        lastWinningLottoNumberChecker = new LastWinningLottoNumberChecker(lastWinningLottoNum);
        lastWinningLottoNumberArray = lastWinningLottoNumberChecker.getLottoWinningNumberArray();
        return issuedLottolist;
    }

    public ArrayList<ArrayList> getLottoList() {
        for (int i = 0; i < numOfLotto; i++) {
            issuedLottolist.add(lotto.issueLotto());
        }
        return issuedLottolist;
    }

    public ArrayList<Integer> getLastWinningLottoNumberArray() {
        return lastWinningLottoNumberArray;
    }

}
