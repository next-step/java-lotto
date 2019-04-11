import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            new IllegalArgumentException();
        }
        this.lotto = lotto;
    }

    public Lotto(int... lottoNumbers) {
        if (lottoNumbers.length != LOTTO_SIZE) {
            new IllegalArgumentException();
        }
        this.lotto = Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int getMatchNumber(Lotto targetLotto) {
        return (int) targetLotto.lotto.stream()
                .filter(number -> this.lotto.contains(number))
                .count();
    }

    public boolean isMatchBonusNumber(LottoNumber bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

}
