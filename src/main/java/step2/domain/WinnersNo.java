package step2.domain;

import java.util.List;

import static step2.domain.Numbers.convertStringToNo;
import static step2.domain.Validator.validateFormula;
import static step2.domain.Validator.validateLottoRangeNumber;

public class WinnersNo {
    private final int bonusNumber;
    private final Numbers winnersResultNos;

    public WinnersNo(int bonusNumber, String input) {
        this.bonusNumber = bonusNumber;
        this.winnersResultNos = convertStringToNo(input);
    }

    public static WinnersNo ofWinnersNo(int bonusNumber, String input) {
        validateLottoRangeNumber(bonusNumber);
        validateFormula(input);
        return new WinnersNo(bonusNumber, input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinnersResultNos() {
        return winnersResultNos.getLotteryInfo();
    }
}
