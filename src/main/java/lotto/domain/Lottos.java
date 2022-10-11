package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int number) {
        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<LottoResult> getResults(Lotto winning) {
        List<LottoResult> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoResult result = lotto.getResult(winning);
            addResult(results, result);
        }
        return results;
    }

    private void addResult(List<LottoResult> results, LottoResult result) {
        if (result != null) {
            results.add(result);
        }
    }

    public int getSize() {
        return lottos.size();
    }

    @Override
    public String toString() {
        String result = "";
        for (Lotto lotto : lottos) {
            result += "[" + lotto.toString() + "]\n";
        }
        return result;
    }
}
