package domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

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

        return matchLottoPrize(bonusNumber, matchNumber);
    }

    private LottoPrize matchLottoPrize(int bonusNumber, int matchNumber) {
        switch (matchNumber) {
            case 6:
                return  LottoPrize.FIRST;
            case 5:
                return checkSecondPrize(bonusNumber);
            case 4:
                return LottoPrize.FOURTH;
            case 3:
                return LottoPrize.FIFTH;
            default:
                return null;
        }
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
