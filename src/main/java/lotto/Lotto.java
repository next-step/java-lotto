package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(){
        LottoNumGenerator lg = new AutoLottoNumGenerator();
        numbers = lg.generate();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
