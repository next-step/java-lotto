package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LottoTicket {
    private List<List<Integer>> bundle = new ArrayList<>();

    public Optional<List<List<Integer>>> getBundle() {
        return Optional.ofNullable(this.bundle);
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
