package step2.domain;

public class LottoMachine {
    static int numOfLotto;
    static String lastWinningLottoNum;
    LastWinningLottoNumberChecker lastWinningLottoNumberChecker;

    public LottoMachine(int numOfLotto, String lastWinningLottoNum) {
        this.numOfLotto = numOfLotto;
        this.lastWinningLottoNum = lastWinningLottoNum;
        lastWinningLottoNumberChecker = new LastWinningLottoNumberChecker(lastWinningLottoNum);
    }
}
