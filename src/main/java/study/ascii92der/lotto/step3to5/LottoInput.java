package study.ascii92der.lotto.step3to5;

public interface LottoInput {
    LottoPrice inputMoney();

    LottoPrice inputManualLottoCount();

    Lottos inputManualLottos(LottoPrice manualLottoPrice);

    Lotto inputWinnerNumbers();

    LottoNumber inputBonusNumber();
}
