package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElectLottoNumbers {

    private ElectLottoNumbers() {
    }

    public static List<Integer> electLottoNumbers(List<Integer> fixedLottoNumbers) {
        List<Integer> electedLottoNumbers = new ArrayList<>(fixedLottoNumbers.subList(0, 6));

        Collections.sort(electedLottoNumbers);
        return electedLottoNumbers;
    }
}
