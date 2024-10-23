package lotto.lotto;

import java.util.*;

public class Lotto {

    public final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto() {
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public List<LottoNumber> getLotto() {
        return lottoNumbers;
    }

    public int findLottoNumber(int idx) {
        return lottoNumbers.get(idx).getNumber();
    }

    public int calculateMatchingCnt(LottoWinning lottoWinning) {
        return (int) lottoNumbers.stream().filter((LottoNumber number) -> lottoWinning.getWinningLotto().contains(number)).count();
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < lottoNumbers.size(); i++) {
            str += findLottoNumber(i) + ",";
        }
        return str.substring(0, str.length() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }

    public boolean isTwoBonusWin(int matchingCount, LottoWinning winning) {
        if (matchingCount == LottoMarginCalculator.RANK_TWO_BONUS.getMachingCnt()) {
            return lottoNumbers.stream().anyMatch(lottoNumber -> winning.getBonusNumber() == lottoNumber.getNumber());
        }
        return false;
    }

}
