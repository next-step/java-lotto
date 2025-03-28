package lotto.domain;

import java.util.List;


public class Lotto {

    private final List<LottoNum> lottoNumbers;
    public static final int LOTTO_SIZE = 6;

    public Lotto(List<LottoNum> lottoNumbers) {
        checkDuplicate(lottoNumbers);
        checkSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }


    private void checkSize(List<LottoNum> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplicate(List<LottoNum> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNum> lottoNumbers() {
        return lottoNumbers;
    }

    public int matchCount(Lotto lastWeekLotto) {
        return (int) this.lottoNumbers().stream()
            .filter(lastWeekLotto.lottoNumbers()::contains)
            .count();
    }

    public boolean matchBonus(LottoNum bonus) {
        return this.lottoNumbers().contains(bonus);
    }


}
