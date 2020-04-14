package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static Lotto ofComma(String stringNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();

        String[] numbers = stringNumbers.split(",");
        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        return new Lotto(lottoNumbers);
    }
}
