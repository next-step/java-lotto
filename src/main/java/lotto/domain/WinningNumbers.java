package lotto.domain;

public class WinningNumbers {

    private final LottoNumbers value;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String winningNumbers, int bonusNumber) {
        this.value = new LottoNumberGenerator().create(winningNumbers);
        this.bonusNumber = new CachedLottoNumbers().getLottoNumber(bonusNumber);
    }

    public Rank getRank(LottoNumbers lottoNumbers) {

        int matchingNumberCount = lottoNumbers.getMatchingCount(value);
        boolean matchBonus = lottoNumbers.hasLottoNumber(bonusNumber);

        return Rank.value(matchingNumberCount, matchBonus);
    }
}
