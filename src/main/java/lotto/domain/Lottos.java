package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private List<Lotto> lottos;

    private static final int LOTTO_PRICE = 1000;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public static int getLottoCount(int totalPrice) {
        if (totalPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000의 배수여야 함");
        }

        return totalPrice / LOTTO_PRICE;
    }

    public static Lottos createLottos(int lottoCount, LottoNumberStrategy strategy) {

        List<Lotto> lottoList = IntStream.range(0, lottoCount)
                .mapToObj(n -> new Lotto(strategy.createNumber())).collect(Collectors.toList());

        return new Lottos(lottoList);
    }



}
