package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AllPossibleLottoNumbers {

    private final static AllPossibleLottoNumbers instance = new AllPossibleLottoNumbers();

    private final static List<LottoNumber> possibleLottoNumbers = generateAllPossibleNumbers() ;

    private static List<LottoNumber> generateAllPossibleNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();

        IntStream
            .range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .forEach(e -> numbers.add(new LottoNumber(e)));

        return numbers;
    }

    public static AllPossibleLottoNumbers getInstance() {
        return instance;
    }

    public List<LottoNumber> drawRandomSixNumbers() {
        Collections.shuffle(possibleLottoNumbers);
        return new ArrayList<>(possibleLottoNumbers.subList(0, 6));
    }
}
