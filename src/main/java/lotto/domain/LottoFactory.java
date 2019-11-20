package lotto.domain;

public class LottoFactory {

    public CreatableLotto getLottoVersionSix() {
        return new LottoVersionSix();
    }

    CreatableLotto createAutoLotto() {
        return new LottoAutoType();
    }

    CreatableLotto createManualLotto(String[] manualLotto) {
        return new LottoManualType(manualLotto);
    }
}
