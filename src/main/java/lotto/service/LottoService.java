package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Purchase;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final Purchase purchase;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoService(int inputMoney) {
        purchase = new Purchase(inputMoney);
    }

    public void generate() {
        for (int i = 0; i < purchase.count(); i++) {
            generateOne();
        }
    }

    private void generateOne() {
        Lotto generatedLotto = new Lotto();
        lottos.add(generatedLotto);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
