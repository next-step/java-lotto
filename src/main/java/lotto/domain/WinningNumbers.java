package lotto.domain;

public class WinningNumbers {

    private final LottoNumbers value;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String winningNumbers, int bonusNumber) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        this.value = lottoNumberGenerator.create(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Rank getRank(LottoNumbers lottoNumbers) {

        int matchingNumberCount = getMatchingCount(lottoNumbers);
        boolean matchBonus = lottoNumbers.hasLottoNumber(bonusNumber);

        return Rank.value(matchingNumberCount, matchBonus);
    }

    private int getMatchingCount(LottoNumbers lottoNumbers) {
        return (int) value.getValue().stream()
                .filter(lottoNumbers::hasLottoNumber)
                .count();
    }
}
