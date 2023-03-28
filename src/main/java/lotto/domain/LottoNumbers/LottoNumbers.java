package lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class LottoNumbers extends ArrayList<Integer> {
    private static final int MAXIMUM_NUMBER = 45;
    private static final int DEFAULT_DIGIT = 6;

    private ArrayList<Integer> lottoNumbers;
    public ArrayList<Integer> LottoNumbers() {
        ArrayList<Integer> lottoNumbers = (ArrayList<Integer>) new Random()
                .ints(1, (MAXIMUM_NUMBER + 1))
                .distinct()
                .limit(DEFAULT_DIGIT)
                .sorted()
                .boxed()
                .collect(toList());

        return lottoNumbers;
    }

}
