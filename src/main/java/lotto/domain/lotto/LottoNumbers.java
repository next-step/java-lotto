package lotto.domain.lotto;

import java.util.*;

public class LottoNumbers {
    private static final List<Integer> LOTTO_NUMBER_LIST = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
            36, 37, 38, 39, 40, 41, 42, 43, 44, 45
    );
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = this.lottoNumbers();
    }

    private List<LottoNumber> lottoNumbers() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();

        final List<Integer> copy = new ArrayList<>(LOTTO_NUMBER_LIST);
        Collections.shuffle(copy);

        final List<Integer> result = copy.subList(0, 6);
        Collections.sort(result);

        for (Integer number : result) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }
}
