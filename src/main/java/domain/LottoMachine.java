package domain;

import domain.lottosGenerator.LottosGenerator;

import java.util.List;

public class LottoMachine {

    public List<Lotto> purchaseLotto(Money money, LottosGenerator lottosGenerator) {
        return lottosGenerator.generate(money);
    }

}
