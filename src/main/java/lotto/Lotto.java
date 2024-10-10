package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    public static List<Set<Integer>> purchase(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 1000 이상이어야 합니다");
        }

        int lottoCount = purchaseAmount / LOTTO_PRICE;
        return generateLottoNumbersList(lottoCount);
    }

    private static List<Set<Integer>> generateLottoNumbersList(int lottoCount) {
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        List<Set<Integer>> lottoNumbersList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> generatedNumbers = lottoNumberGenerator.generateNumbers();
            lottoNumbersList.add(generatedNumbers);
        }

        return lottoNumbersList;
    }
}
