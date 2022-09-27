package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto(List<Integer> lottoNum) {
        this.lotto = lottoNum;
    }

    public Lotto() {
        Random random = new Random();
        this.lotto = new ArrayList<>();
        for(int i = 0 ; i < 6 ; i++){
            int num = random.nextInt(100);
            this.lotto.add(num);
        }
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}