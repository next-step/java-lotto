package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public static Lottos of(PurchaseManager manager,LottoNumberGenerator generator){
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<manager.getPurchasedLottoNumber().getNumber();i++){
            lottoList.add(generator.generate());
        }
        return new Lottos(lottoList);
    }

    public Rank makeStatistic(WinningLotto winningLotto){
        return new Rank(lottoList.stream()
                .collect(groupingBy(lotto->lotto.isWinningLottoList(winningLotto))));
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }
}
