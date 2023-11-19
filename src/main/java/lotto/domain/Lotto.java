package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoNumber.generateLottoNumber;

public class Lotto {

    public static List<Integer> execute() {
        return generateLottoNumber();
    }

    public static List<Integer> execute(int buyCount) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            result.addAll(generateLottoNumber());
        }

        return result;
    }
}
