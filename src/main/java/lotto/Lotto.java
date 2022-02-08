package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    
    private final List<Integer> numbers;
    
    Lotto(LottoRules lottoRules) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> lottoNum = lottoRules.getLottoNums();
        Collections.shuffle(lottoNum);
        for (int i = 0; i < lottoRules.LOTTO_COUNT; i++) {
            numbers.add(lottoNum.get(i));
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }
    
    public int getCount() {
        return numbers.size();
    }
}
