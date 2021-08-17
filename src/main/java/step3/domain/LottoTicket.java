package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<List<Integer>> bundle = new ArrayList<>();

    public List<List<Integer>> getBundle() {
        return bundle;
    }

    public void addLotto(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
        bundle.add(lottoNumbers);
    }

    public void addBundle(List<List<Integer>> lottoBundle) {
        for (List<Integer> lotto: lottoBundle) {
            bundle.add(lotto);
        }
    }
}
