package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.getMatchNumber() == matchNumber)
                .collect(Collectors.toList())
                .get(0);
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
