package lotto.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningLotto(final List<Integer> numbers, final int bonusBall) {
        this.winningLotto = new Lotto(convertLottoNumbers(numbers));
        this.bonusBall = new LottoNumber(bonusBall);
        validateLottoContainBonusBall(this.winningLotto, this.bonusBall);
    }

    private List<LottoNumber> convertLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

    private void validateLottoContainBonusBall(final Lotto lotto, final LottoNumber bonusBall) {
        if (lotto.isContain(bonusBall)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 중복되면 안됩니다.");
        }
    }

    public Rank matchOfRank(final Lotto lotto) {
        int matchCount = computeMatchCount(lotto);
        boolean isBonus = lotto.isContain(bonusBall);
        return Rank.match(matchCount, isBonus);
    }

    private int computeMatchCount(Lotto lotto) {
        return Math.toIntExact(lotto.getLottoNumbers().stream()
                .filter(winningLotto::isContain)
                .count());
    }
}
