package lotto.domain;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto;

    private static List<Integer> toIntegerList(String[] textLottoNumbers) {
        List<Integer> lotto = new ArrayList<>();

        for (String textNumber : textLottoNumbers) {
            lotto.add(Integer.parseInt(textNumber));
        }

        return lotto;
    }

    private static Set<LottoNumber> toLottoNumber(List<Integer> lottoNumbers) {
        Set<LottoNumber> lotto = new HashSet<>();

        for (int number : lottoNumbers) {
            lotto.add(LottoNumber.of(number));
        }

        return lotto;
    }

    public Lotto(String[] textNumbers) {
        this(toIntegerList(textNumbers));
    }

    public Lotto(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = toLottoNumber(numbers);

        checkLottoSize(numbers);
        checkDuplicate(lottoNumbers);

        this.lotto = lottoNumbers;
    }

    private void checkLottoSize(List<Integer> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 개수는 6개여야 합니다.");
        }
    }

    private void checkDuplicate(Set<LottoNumber> lotto) {
        if (lotto.size() < LOTTO_SIZE) {
            throw new IllegalArgumentException("로또에 중복 숫자가 있습니다.");
        }
    }

    private Set<LottoNumber> getLotto() {
        return this.lotto;
    }

    public int match(Lotto userLotto) {
        int count = 0;

        for (LottoNumber number : userLotto.getLotto()) {
            count += isContainsUserLottoNumber(lotto, number) ? 1 : 0;
        }

        return count;
    }

    private boolean isContainsUserLottoNumber(Set<LottoNumber> lotto, LottoNumber number) {
        return lotto.contains(number);
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
