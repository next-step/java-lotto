package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.LottoNumber.*;

public class Lotto {
    public static final int PRICE = 1_000;
    private static final int STARTING_INDEX_LOTTO = 0;
    private static final int LAST_INDEX_LOTTO = 6;

    private static final List<Integer> LOTTO_NUMBERS =
            IntStream.rangeClosed(LOTTO_STARTING_NUMBER, LOTTO_LAST_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LAST_INDEX_LOTTO) {
            throw new IllegalArgumentException("The number of lotto numbers should be exactly 6.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int matchingNumberCount(Lotto winningNumber) {
        return (int) winningNumber.lottoNumbers
                .stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public static int amount(int price) {
        return price / PRICE;
    }

    public static Lotto of() {
        Collections.shuffle(LOTTO_NUMBERS);

        List<LottoNumber> lottoNumbers = LOTTO_NUMBERS.subList(STARTING_INDEX_LOTTO, LAST_INDEX_LOTTO)
                .stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public static Lotto of(List<Integer> numbers) {
        List<LottoNumber> lottonumbers = numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(lottonumbers);
    }
}
