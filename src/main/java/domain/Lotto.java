package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static domain.NumberGenerator.INT_SIX;

public class Lotto {
    private Set<Integer> lottoNumber;

    public Lotto(Set<Integer> set) {
        validateLottoNumber(set);
        this.lottoNumber = set;
    }

    private void validateLottoNumber(Set<Integer> set) {
        validateEmpty(set);
        validateSize(set);
    }

    private void validateSize(Set<Integer> set) {
        if (set.size() != INT_SIX) {
            throw new IllegalArgumentException("not 6 number");
        }
    }

    private void validateEmpty(Set<Integer> set) {
        if (set.size() == 0 || set == null) {
            throw new IllegalArgumentException("empty!");
        }
    }

    public List<Integer> getLottoNumber() {
        return new ArrayList<>(lottoNumber);
    }
}
