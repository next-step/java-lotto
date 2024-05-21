import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .map(LottoNumber::of)
            .collect(Collectors.toList());
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final Set<LottoNumber> value;

    public Lotto() {
        this(fromLottoNumberList(lottoNumbers));
    }

    public static Set<LottoNumber> fromLottoNumberList(List<LottoNumber> value) {
        Collections.shuffle(value);
        value = value.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(value.subList(0, LOTTO_NUMBER_COUNT), Comparator.comparingInt(LottoNumber::get));

        return new HashSet<>(value);
    }

    public Lotto(List<Integer> value) {
        this(value.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public Lotto(Integer... value) {
        this(Arrays.stream(value)
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public Lotto(Set<LottoNumber> value) {
        validate(value);
        this.value = value;
    }

    public Set<LottoNumber> get() {
        return this.value;
    }

    public long countCommonLottoNumbers(Lotto winningLotto) {
        return this.value.stream()
                .filter(winningLotto.get()::contains)
                .count();
    }

    public boolean isWinningBonus(LottoNumber bonusNumber) {
        return this.value.contains(bonusNumber);
    }

    public int size() {
        return this.value.size();
    }

    private static void validate(Set<LottoNumber> value) {
        if (value.size() != 6) {
            throw new IllegalArgumentException("로또번호 개수는 6개만 허용합니다 : " + value.size());
        }
    }
}
