package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<List<Integer>> bundle = new ArrayList<>();

    public List<List<Integer>> getBundle() {
        return this.bundle;
    }

    public void addLotto(List<Integer> lottoNumbers) {
        bundle.add(lottoNumbers);
    }

    public void addBundle(List<List<Integer>> lottoBundle) {
        bundle.addAll(lottoBundle);
    }
}
