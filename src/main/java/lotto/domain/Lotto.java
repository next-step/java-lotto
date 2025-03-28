package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this(new AutoLottoNumberGenerator());
    }

    public Lotto(List<Integer> lottoNumbers) {
        this(new ManualLottoNumberGenerator(lottoNumbers));
    }

    public Lotto(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumbers = lottoNumberGenerator.generate();
    }

    public static int calculateLottoCount(int totalAmount) {
        return totalAmount / LOTTO_PRICE;
    }

    public int getMatchCount(List<LottoNumber> winningNumbers) {
        return (int) this.lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    public boolean matchBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.isContainedIn(this.lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
