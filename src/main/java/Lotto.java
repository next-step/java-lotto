import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final Map<Integer, LottoNumber> lottoNumbersByNumber = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toUnmodifiableMap(
                    i -> i,
                    LottoNumber::new
            ));

    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .map(lottoNumbersByNumber::get)
            .collect(Collectors.toList());

    private final LottoNumbers value;

    public Lotto() {
        this.value = new LottoNumbers(lottoNumbers);
    }

    public LottoNumbers numbers() {
        return this.value;
    }

    public int size() {
        return this.value.get().size();
    }
}
