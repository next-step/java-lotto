package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShopFactory {

    public List<Lotto> purchase(Purchase purchase) {
        return purchase.purchase();
    }

}
