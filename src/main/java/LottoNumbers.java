import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static LottoNumbers fromLottoNumberList(List<LottoNumber> value) {
        Collections.shuffle(value);
        value = value.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(value.subList(0, LOTTO_NUMBER_COUNT), Comparator.comparingInt(LottoNumber::get));

        return fromLottoNumberSet(new HashSet<>(value));
    }

    public static LottoNumbers fromIntegerList(List<Integer> value) {
        return fromLottoNumberSet(value.stream().map(LottoNumber::of).collect(Collectors.toSet()));
    }

    public static LottoNumbers fromIntegers(Integer... value) {
        return fromLottoNumberSet(Arrays.stream(value)
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public static LottoNumbers fromLottoNumberSet(Set<LottoNumber> value) {
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
