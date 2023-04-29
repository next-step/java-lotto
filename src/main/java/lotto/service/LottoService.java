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

    public void autoGenerate() {
        for (int i = 0; i < purchase.count(); i++) {
            autoGenerateOne();
        }
    }

    private void autoGenerateOne() {
        Lotto generatedLotto = Lotto.auto();
        lottos.add(generatedLotto);
    }

    public List<Lotto> lottos(){
        return lottos;
    }
}
