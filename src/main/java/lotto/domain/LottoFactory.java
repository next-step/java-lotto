package lotto.domain;

public class LottoFactory {

    public CreatableLotto getLottoVersionSix() {
        return new LottoVersionSix();
    }

    public CreatableLotto createAutoLotto() {
        return new LottoAutoType();
    }

    public CreatableLotto createManualLotto(String[] manualLotto) {
        return new LottoManualType(manualLotto);
    }
}
