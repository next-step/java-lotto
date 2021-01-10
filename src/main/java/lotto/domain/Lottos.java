package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lottoList = new ArrayList<>();
    private final RandomNumber randomNumber = new RandomNumber();

    public Lottos() {
    }

    public Lottos(List<Lotto> lottos) {
        lottoList.addAll(lottos);
    }

    public Lottos(String[] inputBuyManualLotto) {
        for(String manualLottoNumbers : inputBuyManualLotto) {
            lottoList.add(createManualLotto(manualLottoNumbers));
        }
    }

    private Lotto createManualLotto(String manualLottoNumbers) {
        return new Lotto(manualLottoNumbers);
    }

    public void createAutoNumber(int coin) {
        Stream.iterate(coin, index -> index > 0, loopCoin ->  loopCoin - 1)
            .forEach(s -> lottoList.add(new Lotto(randomNumber.createRandomNumbers())));
    }

    public int buyLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoSize() {
        return lottoList.size();
    }

    public void combineLotto(Lottos manualLotto, Lottos autoLotto) {
        lottoList = Stream.concat(manualLotto.getLottoList().stream(), autoLotto.getLottoList().stream())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(Lotto::toString)
                .toString();
    }
}
