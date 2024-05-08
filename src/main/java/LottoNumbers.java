import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> value;

    public LottoNumbers(List<LottoNumber> value) {
        Collections.shuffle(value);
        value = value.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(value.subList(0, LOTTO_NUMBER_COUNT), Comparator.comparingInt(LottoNumber::get));

        validate(value);

        this.value = value;
    }

    private void validate(List<LottoNumber> value) {
        if (value.size() != 6) {
            throw new IllegalArgumentException("로또번호 개수는 6개만 허용합니다 : " + value.size());
        }
    }

    public List<LottoNumber> get() {
        return this.value;
    }
}
