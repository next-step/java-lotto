package lotto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(Lotto lotto) {
        this.lottos = new ArrayList<>();
        this.lottos.add(lotto);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public boolean isCount(int expectedCount) {
        return this.lottos.size() == expectedCount;
    }

    public void createRandomLotto() {
        this.lottos.add(new Lotto());
    }

    public LottoResult compareWinNumber(Lotto winNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            lotto.compareWinLottoNumber(winNumber, lottoResult);
        }
        return lottoResult;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lottoNumber : lottos) {
            stringBuilder.append(lottoNumber.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
