package refactoringlotto.testrandom;


import refactoringlotto.random.LottoGenerator;

import java.util.List;

public class DefaultLottoList implements LottoGenerator {
    @Override
    public List<Integer> executeStrategy() {
        return List.of(1,2,3,4,5,6);
    }
}
