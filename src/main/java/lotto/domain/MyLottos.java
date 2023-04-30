package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {
    private final List<MyLotto> myLottos;

    public MyLottos(List<MyLotto> myLottos) {
        this.myLottos = myLottos;
    }

    public MyLottos() {
        this(new ArrayList<>());
    }

    public void autoGenerate(int count) {
        for (int i = 0; i < count; i++) {
            autoGenerateOne();
        }
    }

    private void autoGenerateOne() {
        MyLotto generatedMyLotto = MyLotto.auto();
        myLottos.add(generatedMyLotto);
    }

    public void checkWin(WinLotto winLotto, Result result) {
        for (MyLotto myLotto : myLottos) {
            myLotto.checkMatchingNumbers(winLotto);
            result.update(myLotto);
        }
        result.sumPrizeAmount();
    }

    public int count() {
        return myLottos.size();
    }

    public MyLotto find(int index) {
        return myLottos.get(index);
    }
}
