package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchaseLottoList {
    private List<Lotto> purchaseLottoList;

    public PurchaseLottoList(int lottoCount) {
        purchaseLottoList = IntStream.rangeClosed(1, lottoCount)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottoList;
    }
}
