package lotto.service;

import lotto.domain.MyLotto;
import lotto.domain.Purchase;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final Purchase purchase;
    private final List<MyLotto> myLottos = new ArrayList<>();

    public LottoService(int inputMoney) {
        purchase = new Purchase(inputMoney);
    }

    public void autoGenerate() {
        for (int i = 0; i < purchase.count(); i++) {
            autoGenerateOne();
        }
    }

    private void autoGenerateOne() {
        MyLotto generatedMyLotto = MyLotto.auto();
        myLottos.add(generatedMyLotto);
    }

    public List<MyLotto> lottos(){
        return myLottos;
    }
}
