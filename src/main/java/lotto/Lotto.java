package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final List<Integer> PICK_NUMBERS = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                          25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));

    private int purchaseCount;
    private List<LottoNumber> lottoNumbers;

    public Lotto(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public List<Integer> generateRandomNumbers() {
        Collections.shuffle(PICK_NUMBERS);
        List<Integer> numbers = PICK_NUMBERS.subList(0, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public LottoNumber createLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(generateRandomNumbers());
        return lottoNumber;
    }
}
