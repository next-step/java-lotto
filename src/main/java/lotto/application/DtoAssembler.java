package lotto.application;

import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.money.LottoMoney;

import java.util.List;

public class DtoAssembler {
    public static WinningLottoRequest assembleWinningRequest(LottoNumbers lottoNumbers, int bonusNumber) {
        return new WinningLottoRequest(lottoNumbers, bonusNumber);
    }

    public static LottoRequest assembleLottoRequest(LottoMoney lottoMoney, List<LottoNumbers> manualLottoNumbers) {
        return new LottoRequest(lottoMoney, manualLottoNumbers);
    }

    public static LottoBuyResponse assembleLottoByResponse(Lottery lotteryByManual, Lottery lotteryByAuto) {
        return new LottoBuyResponse(lotteryByManual, lotteryByAuto);
    }

}
