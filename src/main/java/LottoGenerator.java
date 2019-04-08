import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBERS;
    private static final int FIRST_INDEX = 0;
    private static final int LOTTO_SIZE = 6;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
                .mapToObj(lottoNumber -> new LottoNumber(lottoNumber))
                .collect(Collectors.toList());
    }

    public static Lotto createLotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        List lotto = LOTTO_NUMBERS.subList(FIRST_INDEX, LOTTO_SIZE);
        Collections.sort(lotto);
        return new Lotto(lotto);
    }
}
