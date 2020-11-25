package step2.domain;

import java.util.List;

public class LottoDTO {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    protected LottoDTO(Lotto lotto) {
        this.numbers = lotto.getNumbers();
    }

    public static LottoDTO createLottoDTO(Lotto lotto) {
        return new LottoDTO(lotto);
    }

}
