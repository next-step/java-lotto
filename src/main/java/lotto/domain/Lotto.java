package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Lotto implements Iterable<LottoNumber> {
    public static final int LOTTO_DIGIT = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validateLottoSize(lotto);
        this.lotto = lotto;
    }

    private void validateLottoSize(List<LottoNumber> lottoNubmers) {
        if(lottoNubmers.size() != LOTTO_DIGIT) {
            throw new IllegalArgumentException("로또는 총 " + LOTTO_DIGIT + "개의 번호로 이뤄져 있습니다.");
        }
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        validateDuplicateLottoNumber(numbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        numbers.forEach(number -> lottoNumbers.add(new LottoNumber(number)));

//        Set<LottoNumber> lottoNumberSet = new TreeSet<>();
//        numbers.forEach(number -> lottoNumberSet.add(new LottoNumber(number)));
//
//        lottoNumbers = lottoNumberSet.stream().collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    private static void validateDuplicateLottoNumber(List<Integer> lottoNumbers) {
        boolean duplicated = lottoNumbers.stream()
                .distinct()
                .count() != lottoNumbers.size();

        if(duplicated) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public Rank matchLotto(WinningLotto winningLotto) {
        Lotto winNumbers = winningLotto.getWinningLotto();
        int matchCount = (int) this.getLotto().stream()
                .filter(lottoNumber -> winNumbers.contains(lottoNumber))
                .count();

        boolean bonus = false;
        if(matchCount == 5) {
            bonus = this.lotto.contains(winningLotto.getBonusNumber());
        }

        return Rank.getRank(matchCount, bonus);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lotto.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lottoCache = (Lotto) o;
        return Objects.equals(lotto, lottoCache.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
