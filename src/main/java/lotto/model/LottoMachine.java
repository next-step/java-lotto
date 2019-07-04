package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    static List<LottoNumber> autoLottoNumber() {
        List<LottoNumber> lottoNumbers = createLottoMachine();
        Collections.shuffle(lottoNumbers);
        return lottoNumbersSort(lottoNumbers.subList(0, 6));
    }

    static List<LottoNumber> lottoNumbersSort(List<LottoNumber> lottoGameNumbers) {
        lottoGameNumbers.sort(Comparator.comparing(LottoNumber::getNumber));
        return lottoGameNumbers;
    }

    static List<LottoNumber> createLottoMachine() {
        List<LottoNumber> lottoNumbers = new ArrayList <>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(Integer.toString(i)));
        }
        return lottoNumbers;
    }

    public static List<LottoOneLine> extractLottoNumbers(int inputLottoGameCount) {
        List<LottoOneLine> lottoOneLines = new ArrayList <>();
        for (int i = 0; i < inputLottoGameCount; i++) {
            lottoOneLines.add(new LottoOneLine(LottoMachine.autoLottoNumber()));
        }
        return lottoOneLines;
    }

    public static void manualLottoNumbers(List<LottoOneLine> lottoOneLines ,List<String> lottoNumbers){
        for(String lottoNum : lottoNumbers){
            lottoOneLines.add(new LottoOneLine(Arrays.stream(lottoNum.split(","))
                                                     .map(LottoNumber::new)
                                                     .collect(Collectors.toList())));
        }
    }
}
