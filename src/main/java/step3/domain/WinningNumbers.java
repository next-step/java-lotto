package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private static final int WINNING_NUMBER_SIZE = 7;

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public static WinningNumbers of(Lotto lotto, LottoNumber bonusNumber) {
        return new WinningNumbers(lotto, bonusNumber);
    }

    private WinningNumbers(Lotto lotto, LottoNumber bonusNumber) {
        inputValidation(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void inputValidation(Lotto lotto, LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.lottoNumbers());
        lottoNumbers.add(bonusNumber);

        if(lotto.contains(bonusNumber)){
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public int matchCount(Lotto lotto) {
        return matchCountWithOutBonus(lotto) + matchCountWithBonus(lotto);
    }

    private int matchCountWithOutBonus(Lotto lotto) {
        return (int) this.lotto.lottoNumbers().stream()
                .filter(lotto::contains)
                .count();
    }

    public int matchCountWithBonus(Lotto lotto) {
        return lotto.contains(bonusNumber) ? 1 : 0;
    }

    public boolean containBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
