package domain;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto (LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createLotto(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public LottoPrize matchLottoNumbers(LottoNumbers winningLotto, int bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int matchNumber =  (int) lottoNumbers.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();

        if(matchNumber < LottoPrize.FIFTH.getMatchNumber()) {
            return null;
        }

        if(matchNumber == LottoPrize.SECOND.getMatchNumber()) {
            return checkSecondPrize(bonusNumber);
        }

        return LottoPrize.matchPrize(matchNumber);
    }

    private LottoPrize checkSecondPrize(int bonusNumber) {
        if(lottoNumbers.getNumbers().contains(bonusNumber)) {
            return LottoPrize.SECOND;
        }
        return LottoPrize.THIRD;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

}
