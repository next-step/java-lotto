package lottogame.controller.spi;

import lottogame.service.request.LottoPurchaseRequest;

import java.util.Set;

public interface LottoInputer {
    Set<Integer> inputWinningLottoNumbers();

    Integer inputBonusLottoNumber();

    LottoPurchaseRequest inputLottoPurchaseRequest();

}
