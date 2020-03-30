package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {
    private static final List<Integer> pickNumber = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                          25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));
    private static final int LOTTO_NUMBER_COUNT = LottoRule.COUNT.getValue();

    private int purchaseCount;
    private final List<LottoNumber> lottoNumbers;

    public LottoGenerator(int purchaseCount) {
        this.purchaseCount = purchaseCount;
        this.lottoNumbers = createLottoNumbersByPurchaseCount();

    }

    private Set<Integer> generateRandomNumbers() {
        Collections.shuffle(pickNumber);
        List<Integer> numbers = pickNumber.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return new LinkedHashSet<>(numbers);
    }

    public List<LottoNumber> createLottoNumbersByPurchaseCount() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            numbers.add(new LottoNumber(generateRandomNumbers()));
        }
        return Collections.unmodifiableList(numbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
