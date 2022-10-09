package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine implements LottoFactory {

    private static final int LOTTO_PRICE = 1000;

    private Lotto createLotto() {
        List<LottoNumber> lottoNumberList = IntStream.rangeClosed(1, 45)
                .mapToObj(no -> new LottoNumber(no))
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumberList);

        List<LottoNumber> createdLotto = lottoNumberList.subList(0, 6);

        Collections.sort(createdLotto);

        return new Lotto(createdLotto);
    }

    @Override
    public List<Lotto> create(int amount) {
        return IntStream.rangeClosed(1, getLottoCount(amount))
                .mapToObj(v -> createLotto())
                .collect(Collectors.toList());
    }

    private int getLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }
}
