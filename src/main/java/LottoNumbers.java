import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 46;
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final static List<LottoNumber> NUMBERS
        = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
        .mapToObj(LottoNumber::new)
        .collect(toList());

    public static List<LottoNumber> select() {
        Collections.shuffle(NUMBERS);
        List<LottoNumber> numbers = NUMBERS.subList(0, LOTTO_NUMBER_SIZE);
        Collections.sort(numbers);
        return numbers;
    }
}
