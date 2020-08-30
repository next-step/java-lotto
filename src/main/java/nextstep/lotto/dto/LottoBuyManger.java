package nextstep.lotto.dto;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_INPUT_MANUAL_GREAT_THAN_TOTAL;
import static nextstep.lotto.dto.LottoResultBoard.LOTTO_VALUE;

public class LottoBuyManger {

    private int totalLottoAmount;
    private int manualLottoAmount;

    private LottoBuyManger(int inputMoney, int manualLottoAmount) {
        int totalLottoAmount = howManyBuyLottoTicket(inputMoney);

        if (totalLottoAmount < manualLottoAmount) {
            throw new IllegalArgumentException(INVALID_INPUT_MANUAL_GREAT_THAN_TOTAL);
        }

        this.totalLottoAmount = totalLottoAmount;
        this.manualLottoAmount = manualLottoAmount;
    }

    public static LottoBuyManger create(int inputMoney, int manualLottoAmount) {
        return new LottoBuyManger(inputMoney, manualLottoAmount);
    }

    private int howManyBuyLottoTicket(int inputMoney) {
        return inputMoney / LOTTO_VALUE;
    }

    public int getAutoAmount() {
        return totalLottoAmount - manualLottoAmount;
    }

    public int getManualLottoAmount() {
        return manualLottoAmount;
    }
}
