package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        valid(lotto);
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> values) {
        List<LottoNumber> lottoNumbers = values.stream()
            .map(LottoNumber::from)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    private boolean isDuplicate(List<LottoNumber> lottoNumbers) {
        int count = (int) lottoNumbers.stream()
            .distinct()
            .count();

        return count != LOTTO_NUMBER_SIZE;
    }

    private void valid(List<LottoNumber> lottoNumbers) {
        if (isDuplicate(lottoNumbers)) {
            throw new IllegalArgumentException("번호는 중복될 수 없습니다.");
        }
    }

    public int size() {
        return this.lotto.size();
    }

    public List<LottoNumber> getLotto() {
        return this.lotto;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public int match(Lotto winningLotto) {
        return (int) lotto.stream()
            .filter(winningLotto::contains)
            .count();
    }

    public boolean matchBonus(LottoNumber bonus) {
        return lotto.stream()
            .anyMatch(userLotto -> userLotto.equals(bonus));
    }
}
