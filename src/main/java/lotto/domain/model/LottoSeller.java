package lotto.domain.model;

import lotto.view.model.UserMoneyInput;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public static final int PRICE = 1000;

    public int getPurchasableLottoCount(UserMoneyInput userInput) {
        return userInput.getMoneyAmount() / PRICE;
    }

    public List<Lotto> generateAndSell(int amount) {
        return Stream.generate(Lotto::createAuto)
                .limit(amount)
                .collect(Collectors.toList());
    }
}
