package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        valid(lotto);
        this.lotto = lotto;
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int matches(Lotto winningNumbers) {
        return (int) winningNumbers.lotto.stream()
            .filter(lotto::contains)
            .count();
    }

    public boolean matches(LottoNumber bonus) {
        return lotto.stream()
            .anyMatch(lottoNumber -> lottoNumber.equals(bonus));
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

    @Override
    public String toString() {
        return String.valueOf(lotto);
    }
}
