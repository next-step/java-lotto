package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManualType implements CreatableLotto {
    private String[] manualLotto;

    public LottoManualType(String[] manualLotto) {
        this.manualLotto = manualLotto;
    }
    @Override
    public List<LottoNo> makeLotto() {
        return Arrays.stream(this.manualLotto)
                .map(number -> new LottoNo(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }
}
