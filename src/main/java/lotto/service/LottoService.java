package lotto.service;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final Purchase purchase;
    private final List<MyLotto> myLottos;
    private final MyLottoResult myLottoResult = new MyLottoResult();


    public LottoService(int inputMoney, List<MyLotto> myLottos) {
        this.purchase = new Purchase(inputMoney);
        this.myLottos = myLottos;
    }

    public LottoService(int inputMoney) {
        this(inputMoney, new ArrayList<>());
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

    public List<MyLotto> lottos() {
        return myLottos;
    }

    public void checkWinLottos(WinLotto winLotto) {
        for (MyLotto myLotto : myLottos) {
            myLotto.checkWinNumber(winLotto);
            myLottoResult.update(myLotto);
        }
        myLottoResult.sumPrizeAmount();
    }

    public int prizeAmount() {
        return myLottoResult.prizeAmount();
    }

    public MyLottoResult getResult() {
        return myLottoResult;
    }
}
