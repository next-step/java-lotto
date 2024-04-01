package lotto.domain;

import lotto.constant.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> lotto;

    private static Set<LottoNumber> toLottoNumber(List<Integer> lottoNumbers) {
        Set<LottoNumber> lotto = new HashSet<>();

        for (int number : lottoNumbers) {
            lotto.add(LottoNumber.of(number));
        }

        return lotto;
    }

    public Lotto(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = toLottoNumber(numbers);

        checkLottoSize(lottoNumbers);
        checkDuplicate(lottoNumbers);

        this.lotto = lottoNumbers;
    }

    private void checkDuplicate(Set<LottoNumber> lotto) {
        if (lotto.size() < Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또에 중복 숫자가 있습니다.");
        }
    }

    private void checkLottoSize(Set<LottoNumber> lotto) {
        if (lotto.size() > Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 개수는 6개여야 합니다.");
        }
    }

    private Set<LottoNumber> getLotto() {
        return this.lotto;
    }

    public int match(Lotto userLotto) {
        int count = 0;

        for (LottoNumber number : userLotto.getLotto()) {
            count += getContainsUserLottoNumber(lotto, number);
        }

        return count;
    }

    private int getContainsUserLottoNumber(Set<LottoNumber> lotto, LottoNumber number) {
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
        List<LottoNumber> lottoList = new ArrayList<>(lotto);
        lottoList.sort(Comparator.comparingInt(LottoNumber::hashCode));
        return lottoList.toString();
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
