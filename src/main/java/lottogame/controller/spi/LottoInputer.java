package lottogame.controller.spi;

import lottogame.controller.request.LottoPurchaseRequest;

import java.util.Set;

public interface LottoInputer {
    Set<Integer> inputWinningLottoNumbers();

    Integer inputBonusLottoNumber();

    LottoPurchaseRequest inputLottoPurchaseRequest();

}
