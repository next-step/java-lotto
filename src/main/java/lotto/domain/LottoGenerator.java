package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<Integer> numbers = new ArrayList<>();

    public LottoGenerator(){
        for(int i =1; i <= 45; i++){
            this.numbers.add(i);
        }
    }

    public List<Integer> randomNumber() {
        Collections.shuffle(numbers);
        List<Integer> shuffleNumbers = new ArrayList<>(numbers.subList(0,6));
        Collections.sort(shuffleNumbers);
        return shuffleNumbers;
    }
}
