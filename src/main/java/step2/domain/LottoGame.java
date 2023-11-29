package step2.domain;

import step2.generator.LottoNumbersMakeStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private final List<Lotto> lottos;

    private final LottoWinGenerator generator;

    public LottoGame(List<Lotto> lottos, LottoWinGenerator generator) {
        this.lottos = lottos;
        this.generator = generator;
    }

    public static LottoGame create(
            final int tryCount
            , final LottoNumbersMakeStrategy numberMakeStrategy
            , final LottoWinGenerator lottoWinGenerator
    ) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottoList.add(Lotto.create(numberMakeStrategy.makeLottoNumber()));
        }
        return new LottoGame(lottoList, lottoWinGenerator);
    }

    public List<Lotto> getLotto() {
        return this.lottos;
    }

    public Prizes game(List<Integer> winNumbers) {
        for (Lotto lotto : lottos) {
            getPrizes(lotto, winNumbers);
        }
        return prizes;
    }

    private Prize getPrizes(final Lotto lotto, List<Integer> winNumbers) {
        return lotto.stream()
                .map(number -> new Prize(getRank(number, winNumbers)))
                .collect(Collectors.toList());
    }

    public Prizes getPrizes() {
        lottos.stream().map(lotto -> {
            return Prize()
        })
    }

    private Rank getRank(int number, List<Integer> winNumbers) {
        List<Integer> prizeNumbers = new ArrayList<>();
        if (winNumbers.contains(number)) {
            prizeNumbers.add(number);
        }
        return Rank.valueOf(prizeNumbers.size());
    }
}
