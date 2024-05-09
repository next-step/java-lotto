import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> lottoNumbersByNumber = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toUnmodifiableMap(
                    i -> i,
                    LottoNumber::new
            ));

    private final int value;

    public static LottoNumber of(int value) {
        return lottoNumbersByNumber.get(value);
    }

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (!(value >= 1 && value <= 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 이내만 허용합니다 : " + value);
        }
    }

    public int get() {
        return this.value;
    }
}
