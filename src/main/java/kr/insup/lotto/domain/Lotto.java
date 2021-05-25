package kr.insup.lotto.domain;

import kr.insup.lotto.config.LottoConfig;
import kr.insup.lotto.utils.NumberGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto(NumberGenerator numberGenerator) {
        this(numberGenerator.generateNumber());
    }

    public Lotto(List<Integer> numbers) {
        for(int i : numbers){
            this.lottoNumbers.add(LottoNumber.of(i));
        }

        validateLotto();
    }

    public void validateLotto() {
        if (isNumberWrongSize()) {
            throw new IllegalArgumentException("로또 번호의 개수가 잘못 되었습니다!");
        }
    }

    private boolean isNumberWrongSize() {
        return lottoNumbers.size() != LottoConfig.LOTTO_COUNT;
    }

    public LottoPrize matchWinningNumber(WinningLotto winningNumber) {
        LottoPrizeSelector lottoPrizeSelector = new LottoPrizeSelector(winningNumber, this);

        return lottoPrizeSelector.selectLottoPrize();
    }

    public boolean hasNumber(LottoNumber number) {
        return hasNumber(number.number());
    }

    public boolean hasNumber(Integer number) {
        return this.lottoNumbers.contains(LottoNumber.of(number));
    }

    public Set<LottoNumber> numbers() {
        return lottoNumbers;
    }
}
