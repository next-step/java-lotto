import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

    private final LottoNumbers value;

    public Lotto() {
        this(LottoNumbers.fromLottoNumberList(lottoNumbers));
    }

    public Lotto(List<Integer> value) {
        this(new LottoNumbers(value));
    }

    public Lotto(LottoNumbers value) {
        this.value = value;
    }

    public long countCommonLottoNumbers(LottoNumbers lottoNumbers) {
        return this.value.countCommonLottoNumbers(lottoNumbers);
    }

    public LottoNumbers numbers() {
        return this.value;
    }
}
