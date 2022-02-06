package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Numbers;

public class LottoGenerator {

    private final static int LOTTO_PRICE = 1000;
    private final static int LOTTO_FIRST_NUMBER = 1;
    private final static int LOTTO_LAST_NUMBER = 45;
    private final static List<Integer> numbers =
        IntStream.rangeClosed(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static int getLottoQuantity(int purchasePrice) {
        if (isLowerThanLeastPrice(purchasePrice)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }
        return purchasePrice / LOTTO_PRICE;
    }

    private static boolean isLowerThanLeastPrice(int price) {
        return price < LOTTO_PRICE;
    }

    public static List<Lotto> getTotalLottoNumbers(int quantity) {
        List<Lotto> totalNumbers = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(getLottoNumbers());
            totalNumbers.add(lotto);
        }
        return totalNumbers;
    }

    public static Numbers getLottoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> pickedNumbers = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(pickedNumbers);

        return new Numbers(pickedNumbers);
    }
}
