package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final String NEXT_LINE = "\n";
    private final List<Lotto> lottoList;
    private final LottoGenerator lottoGenerator;

    public Lottos(LottoGenerator lottoGenerator, int count) {
        this.lottoGenerator = lottoGenerator;
        this.lottoList = create(count);
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.lottoGenerator = null;
    }

    private List<Lotto> create(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoGenerator.generate()))
                .collect(Collectors.toList());
    }

    public int calculateNumbers(LottoWinningNumbers winningNumbers, int count) {
        return Math.toIntExact(this.lottoList
                .stream()
                .filter(lotto -> lotto.compareSameNumberList(winningNumbers.getWinningLotto()).size() == count)
                .filter(lotto -> !lotto.sameFiveNumberListWithBonusNumber(winningNumbers.getWinningLotto()
                        , winningNumbers.getBonusNumber()))
                .count());
    }

    public int calculateNumbersAndBonusNumber(Lotto winningNumbers, int bonusNumber) {
        return Math.toIntExact(this.lottoList
                .stream()
                .filter(lotto -> lotto.sameFiveNumberListWithBonusNumber(winningNumbers, bonusNumber))
                .count());
    }

    public int size() {
        return lottoList.size();
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(lotto -> lotto + NEXT_LINE)
                .collect(Collectors.joining());
    }
}
