package lotto.model;

import lotto.model.generator.LottoGenerator;
import lotto.model.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRequest {

    public static final int LOTTO_PRICE = 1000;

    private final Money money;
    private final List<Lotto> manualLottos;

    public LottoRequest(int money, List<String> manualLottoStrs) {
        this.money = new Money(money);

        if (lottoBuyChance() - manualLottoStrs.size() < 0) {
            throw new IllegalArgumentException("구매 비용이 모자랍니다.");
        }

        this.manualLottos = manualLottoStrs
                .stream()
                .map(str -> List.of(str.split(",")))
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private int lottoBuyChance() {
        return money.buyChance(LOTTO_PRICE);
    }

    public LottoWallet buy() {
        LottoGenerator lottoGenerator = new LottoGenerator(new LottoNumberGenerator());

        int size = lottoBuyChance();
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < size - manualLottos.size(); i++) {
            lottos.add(lottoGenerator.generate());
        }

        return new LottoWallet(lottos, manualLottos.size());
    }
}


