package study.ascii92der.lotto.step3to5;

public interface LottoOutput {
    void printLottoCount(LottoPrice manualLottoPrice, LottoPrice balanceLottoPrice);

    void printLottoNumbers(Lottos lottos);

    void printWinnerResult(WinResult winResult);
}
