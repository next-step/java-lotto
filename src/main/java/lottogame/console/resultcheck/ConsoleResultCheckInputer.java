package lottogame.console.resultcheck;

import java.util.Set;
import lottogame.controller.resultcheck.spi.ResultCheckInputer;

public class ConsoleResultCheckInputer implements ResultCheckInputer {

    @Override
    public Set<Integer> inputWinningLottoNumbers() {
        return null;
    }

    @Override
    public Integer inputBonusLottoNumber() {
        return null;
    }
}
