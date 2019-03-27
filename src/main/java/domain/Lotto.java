package domain;

public class Lotto {
    private static final int BONUS_AVAILABLE_MATCH_COUNT = 5;
    private LottoNumbers lottoNumbers;

    public static Lotto generateLotto(LottoNumbers integers) {
        Lotto lotto = new Lotto();
        lotto.lottoNumbers = integers;
        return lotto;
    }

    public LottoResultStatus getLottoResultStatus(WinningLotto winningLotto) {
        int containsWinningNumberCount = 0;
        boolean bonusYn = false;
        for (int number : winningLotto.getWinningNumber()) {
            if(lottoNumbers.contains(number))
                containsWinningNumberCount ++;
        }

        if( containsWinningNumberCount == BONUS_AVAILABLE_MATCH_COUNT && lottoNumbers.contains(winningLotto.getBonusNumber())) {
            bonusYn = true;
        }

        return LottoResultStatus.findByMatchCount(containsWinningNumberCount, bonusYn);
    }

    public LottoNumbers getLottoNumbers() {
       return this.lottoNumbers;
    }

}
