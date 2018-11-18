package lotto.domain;

import lotto.utils.LottoCollectionUtils;
import lotto.utils.LottoNoGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.LottoCollectionUtils.convert;

public class WinningLotto {

    private Lotto lotto;
    private LottoNo bonusNumber;

    private WinningLotto(Lotto lotto, LottoNo bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(List<LottoNo> numbers, LottoNo bonusNumber) {
        return new WinningLotto(Lotto.create(numbers), bonusNumber);
    }

    public static WinningLotto create(List<Integer> numbers) {
        return new WinningLotto(Lotto.create(LottoNoGenerator.generate(numbers)), null);
    }

    public static WinningLotto create(String winningNumbers, String bonusNumber) {
        List<LottoNo> lottoNumbers = new ArrayList<>();
        for (String number: winningNumbers.split(", ")) {
            lottoNumbers.add(LottoNo.create(number));
        }
        return new WinningLotto(Lotto.create(lottoNumbers), LottoNo.create(bonusNumber));
    }

    public List<LottoNo> getNumbers(){
        return lotto.getNumbers();
    }

    public List<LottoNo> getNumbersWithBonus(){
        return LottoCollectionUtils.merge(lotto.getNumbers(), this.bonusNumber);
    }
}
