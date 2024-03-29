package lotto.domain;

import lotto.constant.Constants;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> lotto;

    private static List<LottoNumber> toLottoNumber(List<Integer> lottoNumbers) {
        List<LottoNumber> lotto = new ArrayList<>();

        for (int number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }

        return lotto;
    }

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = toLottoNumber(numbers);

        checkLottoSize(lottoNumbers);
        checkDuplicate(lottoNumbers);

        this.lotto = lottoNumbers;
    }

    private void checkDuplicate(List<LottoNumber> lotto) {
        if (new HashSet<>(lotto).size() != lotto.size()) {
            throw new IllegalArgumentException("로또에 중복 숫자가 있습니다.");
        }
    }

    private void checkLottoSize(List<LottoNumber> lotto) {
        if (lotto.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 개수는 6개여야 합니다.");
        }
    }

    private List<LottoNumber> getLotto() {
        return this.lotto;
    }

    public int match(Lotto userLotto) {
        int count = 0;

        for (LottoNumber number : userLotto.getLotto()) {
            count += isContainsUserLottoNumber(lotto, number);
        }

        return count;
    }

    private int isContainsUserLottoNumber(List<LottoNumber> lotto, LottoNumber number) {
        if (lotto.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean isContainsBonus(LottoNumber bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Lotto)) return false;
        Lotto lotto1 = (Lotto) object;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

}
