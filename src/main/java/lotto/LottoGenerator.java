package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateByInputNumber(Integer inputNumber) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < inputNumber; index++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    public Lotto generate() {
        return new Lotto();
    }
}
