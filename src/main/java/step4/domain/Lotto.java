package step4.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto = new LinkedHashSet<>();
    private LottoType lottoType;

    public Lotto(List<LottoNumber> numbers) {
        ListNumberToLotto(numbers);
    }

    private void ListNumberToLotto(List<LottoNumber> numbers) {
        validateLottoSize(numbers);

        for (LottoNumber lottoNumber : numbers) {
            lotto.add(LottoNumber.of(lottoNumber.getNumber()));
        }
    }

    private void validateLottoSize(List<LottoNumber> numbers) {
        int numbersSize = Optional.ofNullable(numbers)
                            .map(List::size)
                            .orElse(0);
        if (numbersSize != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 값이어야 합니다.");
        }
    }

    public Lotto(List<LottoNumber> numbers, LottoType lottoType) {
        ListNumberToLotto(numbers);

        this.lottoType = lottoType;
    }

    public Lotto(String lottoNumber) {
        stringLottoNumberToLotto(lottoNumber);
    }

    private void stringLottoNumberToLotto(String lottoNumber) {
        String[] winNumbers = lottoNumber.split(", ");

        for (int i = 0; i < winNumbers.length; i++) {
            lotto.add(LottoNumber.of(Integer.parseInt(winNumbers[i])));
        }
    }

    public Lotto(String lottoNumber, LottoType lottoType) {
        stringLottoNumberToLotto(lottoNumber);

        this.lottoType = lottoType;
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(this.lotto);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lotto.contains(lottoNumber);
    }

    public LottoType getLottoType() {
        return lottoType;
    }
}
