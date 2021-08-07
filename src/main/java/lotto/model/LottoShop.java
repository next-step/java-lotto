package lotto.model;

import lotto.exception.LackMoneyException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class LottoShop {
    private static final LottoMachine LOTTO_MACHINE = LottoMachine.getInstance();

    public static final int LOTTO_PRICE = 1_000;

    private static LottoShop instance;

    private LottoShop() {
    }

    public static synchronized LottoShop getInstance() {
        if (Objects.isNull(instance)) {
            instance = new LottoShop();
        }
        return instance;
    }

    public Lottos buy(final int payment, final int autoNumberOfPurchases, final String... manualNumbers) {
        validate(payment);

        List<Lotto> lottos = stream(manualNumbers)
                .map(this::getManualLotto)
                .collect(toList());

        lottos.addAll(Stream.generate(this::getAutoLotto)
                            .limit(autoNumberOfPurchases)
                            .collect(toList()));

        return Lottos.from(lottos);
    }

    private void validate(final int payment) {
        if (payment < LOTTO_PRICE) {
            throw new LackMoneyException();
        }
    }

    private Lotto getManualLotto(String lottoNumber) {
        return LOTTO_MACHINE.manual(lottoNumber);
    }

    private Lotto getAutoLotto() {
        return LOTTO_MACHINE.auto();
    }
}
