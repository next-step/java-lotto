package kr.heesu.lotto.domain;

import java.util.List;

public class ManualLottoInputs {

    private final List<String> lottoInputs;

    private ManualLottoInputs(List<String> lottoInputs) {
        this.lottoInputs = lottoInputs;
    }

    public static ManualLottoInputs of(List<String> lottoInputs) {
        return new ManualLottoInputs(lottoInputs);
    }

    public List<String> getLottoInputs() {
        return this.lottoInputs;
    }

    public int getSize() {
        return this.lottoInputs.size();
    }
}
