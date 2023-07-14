package lottogame.controller.spi;

import java.util.Set;

public interface LottoInputer {
    int inputMoney();
    Set<Integer> inputWinningLottoNumbers();

    Integer inputBonusLottoNumber();

}
