package lotto.domain;

import java.util.List;

public class Lottoes {

    private final List<LottoNumbers> value;

    public Lottoes(List<LottoNumbers> value) {
        this.value = value;
    }

    public List<LottoNumbers> getValue() {
        return value;
    }
}
