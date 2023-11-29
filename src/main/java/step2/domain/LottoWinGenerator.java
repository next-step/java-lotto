package step2.domain;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.FALSE;

public class LottoWinGenerator implements WinGenerator {

    @Override
    public boolean isWin(Rank rank) {
        return false;
    }
}
