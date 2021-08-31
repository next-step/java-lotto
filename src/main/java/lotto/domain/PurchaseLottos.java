package lotto.domain;


import lotto.LottoConfig;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchaseLottos {
    private List<Lotto> purchaseLottoList;

    public PurchaseLottos(int lottoCount) {
        purchaseLottoList = IntStream.rangeClosed(1, lottoCount)
                .mapToObj(i -> new Lotto(getRandomIntegerList()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottoList;
    }

    private List<Integer> getRandomIntegerList() {
        List<Integer> returnList = IntStream.rangeClosed(LottoConfig.LOTTO_START_NUMBER, LottoConfig.LOTTO_LAST_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(returnList);

        return returnList.stream().limit(LottoConfig.LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }
}
