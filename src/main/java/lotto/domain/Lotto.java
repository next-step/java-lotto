package lotto.domain;

import java.util.List;

public class Lotto {

    List<LottoNo> numberList;

    public Lotto() {
    }

    public Lotto(List<LottoNo> numberList) {
        this.numberList = numberList;
    }

    public boolean isContainsNumber(LottoNo lottoNo) {
        return numberList.contains(lottoNo);
    }

    public int checkRightNumberCount(List<LottoNo> winningNumbers) {

        int rightCount = (int) winningNumbers.stream()
                .filter(winningNumber -> isContainsNumber(winningNumber))
                .count();

        return rightCount;
    }
    public boolean checkRightBonusNumber(LottoNo bonusNumber) {
        return numberList.stream()
                .filter(lottoNo -> lottoNo.equals(bonusNumber))
                .findAny()
                .isPresent();
    }

    public Prize getLottoPrize(List<LottoNo> winningNumbers, LottoNo bonusNumber) {
        int rightCount = checkRightNumberCount(winningNumbers);
        boolean isRightBonusNumber = checkRightBonusNumber(bonusNumber);
        return Prize.valueOf(rightCount, isRightBonusNumber);
    }

    public List<LottoNo> getLottoNumber() {
        return numberList;
    }
}
