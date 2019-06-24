package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public static List<Integer> autoLottoNumber() {
        List <Integer> lottoNumbers = createLottoMachine();
        Collections.shuffle(lottoNumbers);
        return lottoNumbersSort(lottoNumbers.subList(0, 6));
    }

    private static List<Integer> lottoNumbersSort(List <Integer> lottoGameNumbers) {
        Collections.sort(lottoGameNumbers);
        return lottoGameNumbers;
    }

    static List<Integer> createLottoMachine() {
        List<Integer> lottoNumbers = new ArrayList <>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }
}
