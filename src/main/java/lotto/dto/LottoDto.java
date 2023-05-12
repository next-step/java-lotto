package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDto {
    private final List<Integer> lotto;

    public LottoDto(List<Integer> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }
    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
