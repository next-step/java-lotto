package lottogame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottos {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottos(List<Integer> numbers,int bonusNumber) {
        this.lottoNumbers = createLottoNumbers(numbers);
        this.bonusNumber =  new LottoNumber(bonusNumber);
    }

    public Rank getRank(Lottos lottos) {
        return Rank.find(match(lottos), matchBonusNumber(lottos));
    }

    public Number getPrize(Lottos lottos) {
        return Number.from(Rank.findPrize(match(lottos), matchBonusNumber(lottos)));
    }

    private boolean matchBonusNumber(Lottos lottos) {
        return lottos.match(bonusNumber);
    }

    public int size() {
        return lottoNumbers.size();
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private int match(Lottos lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::match)
                .count();
    }
}
