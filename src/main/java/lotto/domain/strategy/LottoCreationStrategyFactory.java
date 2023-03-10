package lotto.domain.strategy;

import lotto.domain.enums.LottoType;
import lotto.ui.LottoRequest;

public class LottoCreationStrategyFactory {

    public static LottoCreationStrategy createLottoStrategy(final LottoRequest request) {
        String type = request.getType();
        LottoType lottoType = LottoType.fromType(type);
        int price = request.getPrice();

        if (lottoType == LottoType.AUTO) {
            return new AutoCreationStrategy(price);
        }

        if (lottoType == LottoType.MANUAL) {
            return new ManualCreationStrategy(price);
        }

        throw new IllegalArgumentException("Unknown lotto type: " + type);
    }
}
