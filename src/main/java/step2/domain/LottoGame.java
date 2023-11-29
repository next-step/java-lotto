package step2.domain;

import step2.generator.LottoNumbersMakeStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    private final List<Lotto> lottos;


    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGame create(
            final int tryCount
            , final LottoNumbersMakeStrategy numberMakeStrategy
    ) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottoList.add(Lotto.create(numberMakeStrategy.makeLottoNumber()));
        }
        return new LottoGame(lottoList);
    }

    public List<Lotto> getLotto() {
        return this.lottos;
    }

    public Prizes game(WinGenerator generator) {
        return new Prizes(getPrizes(generator));
    }

    public void setWinNumbers(List<Integer> winNumbers) {
//        generator.
    }

    public List<Prize> getPrizes(WinGenerator generator) {
        return lottos.stream()
                .map(generator::winPrize)
                .collect(Collectors.toList());
    }

    private Rank getRank(int number, List<Integer> winNumbers) {
        List<Integer> prizeNumbers = new ArrayList<>();
        if (winNumbers.contains(number)) {
            prizeNumbers.add(number);
        }
        return Rank.valueOf(prizeNumbers.size());
    }
}
