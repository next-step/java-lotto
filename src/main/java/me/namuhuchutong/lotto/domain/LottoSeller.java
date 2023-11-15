package me.namuhuchutong.lotto.domain;

import me.namuhuchutong.lotto.dto.LottoResult;
import me.namuhuchutong.lotto.domain.generator.NumberGenerator;
import me.namuhuchutong.lotto.dto.UserInputInformation;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    private final NumberGenerator generator;

    public LottoSeller(NumberGenerator generator) {
        this.generator = generator;
    }

    public LottoResult sellLotto(UserInputInformation information) {
        int amount = information.getAmount();
        Number bonusNumber = new Number(information.getBonusNumber());
        validateAmount(amount);
        Lotto lotto = Lotto.create(
                amount / LOTTO_PRICE,
                generator,
                information.getManualNumbers());
        return lotto.getMatchNumbers(information.getNumbers(), bonusNumber);
    }

    private void validateAmount(int amount) {
        if (amount / 1000 == 0) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다.");
        }
    }
}
