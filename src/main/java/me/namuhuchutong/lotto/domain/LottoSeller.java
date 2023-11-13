package me.namuhuchutong.lotto.domain;

import me.namuhuchutong.lotto.dto.LottoResult;
import me.namuhuchutong.lotto.domain.generator.NumberGenerator;
import me.namuhuchutong.lotto.dto.UserInputInformation;

public class LottoSeller {

    private final NumberGenerator generator;

    public LottoSeller(NumberGenerator generator) {
        this.generator = generator;
    }

    public LottoResult sellLotto(UserInputInformation information) {
        int amount = information.getAmount();
        validateAmount(amount);
        int times = amount / 1000;
        Lotto lotto = Lotto.create(times, generator);
        return lotto.getMatchNumbers(information.getNumbers());
    }

    private void validateAmount(int amount) {
        if (amount / 1000 == 0) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다.");
        }
    }
}
