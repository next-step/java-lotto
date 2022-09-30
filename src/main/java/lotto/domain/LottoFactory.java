package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoFactory {
    private static final String DEFAULT_DELIMITER = ",";

    public static Lotto create(String lottoNumbers) {
        StringTokenizer tokenizer = new StringTokenizer(lottoNumbers, DEFAULT_DELIMITER);

        List<LottoNumber> numbers = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String number = tokenizer.nextToken();
            numbers.add(LottoNumber.of(number));
        }

        return new Lotto(numbers);
    }

    public static Lottos createPerPrice(int money) {
        int quantity = money / Lotto.PRICE;
        return Lottos.create(quantity);
    }
}
