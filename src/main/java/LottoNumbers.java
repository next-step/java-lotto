import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static LottoNumbers of(List<LottoNumber> value) {
        Collections.shuffle(value);
        value = value.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(value.subList(0, LOTTO_NUMBER_COUNT), Comparator.comparingInt(LottoNumber::get));

        return of(new HashSet<>(value));
    }

    public static LottoNumbers of(Integer... value) {
        return of(Arrays.stream(value)
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public static LottoNumbers of(LottoNumber... value) {
        return of(Arrays.stream(value).collect(Collectors.toSet()));
    }

    public static LottoNumbers of(Set<LottoNumber> value) {
        return new LottoNumbers(value);
    }

    private final Set<LottoNumber> value;

    private LottoNumbers(Set<LottoNumber> value) {
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
