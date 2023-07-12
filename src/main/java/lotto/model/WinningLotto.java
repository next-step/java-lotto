package lotto.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(final List<Integer> lottoNumbers, final int bonus) {
        this.winningLotto = new Lotto(convertLottoNumbers(lottoNumbers));
        this.bonusBall = new LottoNumber(bonus);
        validateDuplicate(this.winningLotto, this.bonusBall);
    }

    private List<LottoNumber> convertLottoNumbers(final List<Integer> integers) {
        return integers.stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

    private void validateDuplicate(final Lotto lottoNumbers, final LottoNumber bonus) {
        if (lottoNumbers.isContain(bonus)) {
            throw new IllegalStateException("당첨 번호와 보너스 볼은 중복되면 안됩니다.");
        }
    }

    public Rank compare(final Lotto lotto) {
        int count = (int) lotto.getLottoNumbers().stream()
                .filter(winningLotto::isContain)
                .count();
        boolean isBonus = lotto.isContain(bonusBall);
        return Rank.match(count, isBonus);
    }
}
