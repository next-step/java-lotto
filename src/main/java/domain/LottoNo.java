package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static util.Validation.validateLottoNo;

public class LottoNo {

    private static final Map<Integer, LottoNo> lottoNos = new HashMap<>();

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    static {
        for (int i = 1; i < 46; i++) {
            lottoNos.put(i, new LottoNo(i));
        }
    }

    private int number;

    private LottoNo(int number) {
        validateLottoNo(number);
        this.number = number;
    }

    public static LottoNo from(int number) {
        return new LottoNo(number);
    }

    public int getNumber() {
        return number;
    }

    public static List<LottoNo> generateLottoNos(List<Integer> numbers){
        return numbers.stream()
                .map(lottoNos::get)
                .collect(Collectors.toList());
    }

    public boolean isExistBonusNumber(LottoNo bonusNumber) {
        return getNumber() == bonusNumber.getNumber();
    }
}
