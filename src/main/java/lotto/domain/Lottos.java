package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

// NOTE: Lotto 의 일급 컬렉션
public class Lottos {
    List<Lotto> lottos;

    public Lottos() {
        lottos = new LinkedList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public void add(Integer[] lottoNos) {
        Lotto lotto = LottoFactory.createLotto(lottoNos);
        add(lotto);
    }

    public void add(String[] lottoNos) {
        Lotto lotto = LottoFactory.createLotto(lottoNos);
        add(lotto);
    }

    public void add(String lottoStr) {
        Lotto lotto = LottoFactory.createLotto(lottoStr);
        add(lotto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos.toString(), lottos1.lottos.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos.toString());
    }
}
