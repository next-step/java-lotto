package lottogame.controller.spi;

import java.util.Set;

public interface Inputer {

    int inputMoney();

    Set<Integer> inputWinningLottoNumbers();

    Integer inputBonusLottoNumber();

}
