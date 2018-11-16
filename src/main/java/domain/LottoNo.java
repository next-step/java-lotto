package domain;

import java.util.List;
import java.util.stream.Collectors;

import static util.Validation.validateLottoNo;

public class LottoNo {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private int number;

    public LottoNo(int number) {
        validateLottoNo(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static List<LottoNo> generateLottoNos(List<Integer> numbers){
        return numbers.stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());

    }

    public boolean isExistBonusNumber(LottoNo bonusNumber) {
        return getNumber() == bonusNumber.getNumber();
    }
}
