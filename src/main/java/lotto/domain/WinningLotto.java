package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lottoNumbers = createLottonumbers(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Rank getRank(Lotto lotto) {
        return Rank.findRank(match(lotto), matchBonusNumber(lotto));
    }

    public int getReward(Lotto lotto) {
        return Rank.findReward(match(lotto), matchBonusNumber(lotto));
    }

    private int match(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    private List<LottoNumber> createLottonumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
