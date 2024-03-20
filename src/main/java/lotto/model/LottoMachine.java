package lotto.model;

import lotto.dto.OrderRequest;

import java.util.ArrayList;
import java.util.List;

import static lotto.validation.LottoMachineValidator.assertMoney;

public class LottoMachine {
    public static final int LOTTO_PER_MONEY = 1_000;

    private LottoMachine() {
    }

    public static LottoPaper purchase(OrderRequest request) {
        Money money = request.getMoney();

        assertMoney(money);

        List<Lotto> manualLottos = request.getManualLottos();
        List<Lotto> automaticLottos = createAutomaticLottos(request.automaticQuantity());

        return new LottoPaper(automaticLottos, manualLottos);
    }

    private static List<Lotto> createAutomaticLottos(int quantity) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            result.add(new Lotto(LottoNumberFactory.selectRandomLottoNumbers()));
        }

        return result;
    }

}
