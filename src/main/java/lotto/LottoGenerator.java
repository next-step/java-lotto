package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final List<Integer> pickNumber = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                          25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));
    private static final int LOTTO_NUMBER_COUNT = LottoRule.COUNT.getValue();

    private int purchaseCount;
    private LottoTicket lottoTicket;

    public LottoGenerator(int purchaseCount) {
        this.purchaseCount = purchaseCount;
        this.lottoTicket = createLottoNumbersByPurchaseCount();

    }

    private Set<LottoNo> generateRandomNumbers() {
        Collections.shuffle(pickNumber);
        List<Integer> numbers = pickNumber.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);

        return numbers.stream().map(item -> new LottoNo(item)).collect(
                Collectors.toCollection(LinkedHashSet::new));
    }

    public LottoTicket createLottoNumbersByPurchaseCount() {
        List<LottoNumbers> numbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            numbers.add(new LottoNumbers(generateRandomNumbers()));
        }
        return new LottoTicket(numbers);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
