package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import domain.type.LottoRankResult;
import view.InputView;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int autoLottoCount) {
        this.lottos = makeLottoList(autoLottoCount);
    }

    public Lottos(int manualLottoCount, int autoLottoCount) {
        List<Lotto> newLottos = new ArrayList<>();
        IntStream.range(0, manualLottoCount).forEach(it -> {
            String stringLotto = InputView.scanManualLotto();
            newLottos.add(new Lotto(stringLotto));
        });
        newLottos.addAll(makeLottoList(autoLottoCount));
        this.lottos = newLottos;
    }

    List<Lotto> makeLottoList(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<Lotto>();

        IntStream.range(0, lottoCount)
                .forEach(it -> lottoList.add(it, new Lotto()));

        return lottoList;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoRankResult, Integer> getLottoRankCount(FirstPlaceLotto firstPlaceLotto) {
        Map<LottoRankResult, Integer> map = new HashMap<>();
        List.of(LottoRankResult.values()).stream()
                .forEach(it -> map.put(it, getLottoRankCount(it, firstPlaceLotto)));
        return map;
    }

    private int getLottoRankCount(LottoRankResult lottoRankAmount, FirstPlaceLotto firstPlaceLotto) {
        return lottos.stream()
                .filter(lotto -> lotto.calculateLottoRank(firstPlaceLotto) == lottoRankAmount)
                .toArray().length;
    }

    public int size() {
        return lottos.size();
    }

}
