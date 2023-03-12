package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    public static List<LottoNumber> generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, 6);
        lottoNumbers.sort(new LottoNumberComparator());
        return lottoNumbers;
    }

    public static List<LottoNumber> generateLottoNumbers(List<String> input) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        input.stream().forEach(number -> lottoNumbers.add(new LottoNumber(Integer.parseInt(number))));
        lottoNumbers.sort(new LottoNumberComparator());

        return lottoNumbers.subList(0, 6);
    }
}
