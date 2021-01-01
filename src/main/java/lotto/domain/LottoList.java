package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoList {
    private final List<Lotto> lottoList = new ArrayList<>();
    private final RandomNumber randomNumber = new RandomNumber();

    public LottoList() {
    }

    public LottoList(List<Lotto> lottos) {
        lottoList.addAll(lottos);
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

    @Override
    public String toString() {
        return lottoList.stream()
                .map(Lotto::toString)
                .toString();
    }
}
