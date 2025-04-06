package lotto;


import java.util.Objects;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this(LottoNumberGenerator.generateLottoNumbers());
    }

    public Lotto(int[] numbers) {
        this(new LottoNumbers(numbers));
    }

    public Lotto(String numberString) {
        this(LottoNumberGenerator.parseIntsFromString(numberString));
    }

    public Lotto(LottoNumbers numbers) {
        lottoNumbers = numbers;
    }

    public int[] getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public int getMatchCount(Lotto lotto) {
        return lottoNumbers.getContainsCount(lotto.lottoNumbers);
    }

    public boolean isMatchedBonus(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }

}
