package step2.Domain;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public static Lottos of(LottoNumberGenerator generator){
        return new Lottos(generator.generate());
    }

    public Rank makeStatistic(WinningLotto winningLotto){
        return new Rank(lottoList.stream()
                .collect(groupingBy(lotto->lotto.isWinningLottoList(winningLotto))));
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }
}
