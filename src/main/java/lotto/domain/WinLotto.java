package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinLotto {

    private List<LottoNumber> winLotto;
    private LottoNumber bonus;

    public WinLotto(List<LottoNumber> winLotto, LottoNumber bonus) {
        validEmpty(winLotto);
        this.winLotto = winLotto;
        this.bonus = bonus;
    }

    public static WinLotto ofNumbers(List<Integer> lottoNumbers, int bonus) {
        validEmpty(lottoNumbers);
        return new WinLotto(createLottoNumber(lottoNumbers), createLottoNumber(bonus));
    }

    private static List<LottoNumber> createLottoNumber(List<Integer> lottoNumbers) {
        return lottoNumbers
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private static LottoNumber createLottoNumber(int bonus) {
        return new LottoNumber(bonus);
    }

    private static void validEmpty(List<?> lotto) {
        if (lotto == null || lotto.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다");
        }
    }

    public int size() {
        return winLotto.size();
    }

    public int getFeatNumberCount(Lotto lotto) {
        return (int) lotto.getLotto().stream()
                .filter(value -> this.winLotto.contains(value))
                .count();
    }

    public boolean isContainBonus(Lotto lotto) {
        return lotto.getLotto().contains(bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinLotto lotto1 = (WinLotto) o;
        return Objects.equals(winLotto, lotto1.winLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winLotto);
    }
}
