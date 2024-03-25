package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoGenerator(){
        for(int i =1; i <= 45; i++){
            this.lottoNumbers.add(i);
        }
    }

    public List<Integer> randomNumber() {
        Collections.shuffle(lottoNumbers);
        List<Integer> shuffleNumbers = new ArrayList<>(lottoNumbers.subList(0,6));
        Collections.sort(shuffleNumbers);
        return shuffleNumbers;
    }
}
