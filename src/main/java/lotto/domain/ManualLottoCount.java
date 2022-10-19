package lotto.domain;

import lotto.domain.exception.CannotBeGreaterPlayableLottoCount;
import lotto.domain.exception.NotNumberStringException;

public class ManualLottoCount extends PlayLottoCount {

    public ManualLottoCount(PlayLottoCount playLottoCount, int value) {
        super(value);
        if (playLottoCount.getValue() < value) {
            throw CannotBeGreaterPlayableLottoCount.getInstance();
        }
    }

    public ManualLottoCount(PlayLottoCount playLottoCount, String value) {
        this(playLottoCount, parseInt(value));
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw NotNumberStringException.getInstance();
        }
    }
}
