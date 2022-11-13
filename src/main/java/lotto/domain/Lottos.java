package lotto.domain;

import java.util.*;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(){
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> findLottoResult(WinningLotto winningLotto) {

        Map<Rank, Integer> lottoResult = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchOfLottoNumber = winningLotto.countSameNumber(lotto.getLotto());

            if (3<=matchOfLottoNumber && matchOfLottoNumber<=6) {
                lottoResult.put(Rank.of(matchOfLottoNumber), lottoResult.getOrDefault(matchOfLottoNumber,0)+1);
            }
        }
        return lottoResult;
    }

    public int getSize() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }


    @Override
    public String
    toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
