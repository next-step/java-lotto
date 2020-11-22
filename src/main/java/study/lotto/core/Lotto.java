package study.lotto.core;

import study.lotto.core.exception.AlreadyLotteryLottoException;
import study.lotto.core.exception.LottoNumberCountNotMatchingException;

import java.util.*;

public class Lotto {

    public static final int PRICE_PER_LOTTO = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;
    private LottoStatus lottoStatus;

    public Lotto(Set<LottoNumber> lottoNumbers) {

        this.lottoNumbers = Optional.ofNullable(lottoNumbers)
                .map(ArrayList::new)
                .orElseThrow(() -> new LottoNumberCountNotMatchingException());

        this.lottoStatus = LottoStatus.BEFORE_LOTTERY;

        sortLottoNumbers();
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public WinningLotto lottery(WinLottoNumbers winLottoNumbers) {

        if (this.lottoStatus == LottoStatus.HAS_BEEN_LOTTERY) {
            throw new AlreadyLotteryLottoException();
        }

        this.lottoStatus = LottoStatus.HAS_BEEN_LOTTERY;

        List<LottoNumber> lottoNumbers = Optional.ofNullable(winLottoNumbers)
                .map(winningNumbers -> winningNumbers.matchWithWinLottoNumbers(this))
                .orElse(new ArrayList<>());

        boolean matchWithBonusLottoNumber = Optional.ofNullable(winLottoNumbers)
                .map(winningNumbers -> winningNumbers.matchWithBonusLottoNumber(this))
                .orElse(false);

        return new WinningLotto(lottoNumbers, matchWithBonusLottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

}
