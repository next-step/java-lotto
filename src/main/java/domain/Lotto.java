package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static domain.NumberGenerator.INT_SIX;

public class Lotto {
    private List<Integer> lottoNumber;

    public Lotto() {

    }

    public Lotto(List<Integer> list) {
        validateLottoNumber(list);
        this.lottoNumber = list;
    }

    private void validateLottoNumber(List<Integer> list) {
        validateDuplicate(list);
        validateEmpty(list);
        validateSize(list);
    }

    private void validateSize(List<Integer> list) {
        if (list.size() != INT_SIX) {
            throw new IllegalArgumentException("not 6 number");
        }
    }

    void validateEmpty(List<Integer> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException("empty!");
        }
    }

    void validateDuplicate(List<Integer> list) {
        Set<Integer> set = new HashSet<>();

        for (Integer number : list) {
            set.add(number);
        }
        if (set.size() != list.size()) {
            throw new IllegalArgumentException("duplicated!!");
        }
    }


    public List<Integer> getLottoNumber() {
        return new ArrayList<>(lottoNumber);
    }
}
