package lotto.domain;

import lotto.util.NullCheckUtil;

public class AutoLottoCount extends PlayLottoCount {

    public AutoLottoCount(int value) {
        super(value);
    }

    public static AutoLottoCount of(PlayLottoCount playLottoCount, PlayLottoCount manualLottoCount) {
        NullCheckUtil.validate(playLottoCount);
        NullCheckUtil.validate(manualLottoCount);
        return new AutoLottoCount(playLottoCount.subtract(manualLottoCount));
    }
}
