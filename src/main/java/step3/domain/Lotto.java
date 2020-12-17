package step3.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto = new LinkedHashSet<>();

    public Lotto(List<LottoNumber> numbers) {
        validateLottoSize(numbers);

        for (LottoNumber lottoNumber : numbers) {
            lotto.add(LottoNumber.of(lottoNumber.getNumber()));
        }
    }

    public Lotto(String lottoNumber) {
        String[] winNumbers = lottoNumber.split(", ");

        for (int i = 0; i < winNumbers.length; i++) {
            lotto.add(LottoNumber.of(Integer.parseInt(winNumbers[i])));
        }
    }

    private void validateLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 값이어야 합니다.");
        }
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(this.lotto);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lotto.contains(lottoNumber);
    }
}
