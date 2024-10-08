package lotto.domain.number;

import lotto.constant.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final String EMPTY_STR = "";
    private static final String DELIMITER = ",";
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = Collections.unmodifiableList(lotto);
    }

    public static Lotto create() {
        return new Lotto(LottoGenerator.generate());
    }

    public static Lotto of(String lottoNumberString) {
        List<String> numbers = Arrays.stream(Objects.requireNonNull(lottoNumberString).split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        validateNumbers(numbers);

        return new Lotto(numbers.stream()
                .map(str -> LottoNumber.of(Integer.parseInt(str)))
                .collect(Collectors.toList()));
    }

    private static void validateNumbers(List<String> numbers) {
        Set<String> numberSet = new HashSet<>(numbers);
        if (numberSet.contains(EMPTY_STR) || numberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
        }
    }

    public int match(Lotto compared) {
        int match = 0;
        for (LottoNumber number : compared.lotto) {
            match += compare(number);
        }
        return match;
    }

    private int compare(LottoNumber compared) {
        return lotto.contains(compared) ? 1 : 0;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
