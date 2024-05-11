import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static LottoNumbers fromLottoNumberList(List<LottoNumber> value) {
        Collections.shuffle(value);
        value = value.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(value.subList(0, LOTTO_NUMBER_COUNT), Comparator.comparingInt(LottoNumber::get));

        return new LottoNumbers(new HashSet<>(value));
    }

    public LottoNumbers(List<Integer> value) {
        this(value.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public LottoNumbers(Integer... value) {
        this(Arrays.stream(value)
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    private final Set<LottoNumber> value;

    public LottoNumbers(Set<LottoNumber> value) {
        validate(value);
        this.value = value;
    }

    public Set<LottoNumber> get() {
        return this.value;
    }

    public long countCommonLottoNumbers(LottoNumbers lottoNumbers) {
        return this.value.stream()
                .filter(lottoNumbers.get()::contains)
                .count();
    }

    private static void validate(Set<LottoNumber> value) {
        if (value.size() != 6) {
            throw new IllegalArgumentException("로또번호 개수는 6개만 허용합니다 : " + value.size());
        }
    }
}
