package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
    private int[] lotto;

    public int[] getLotto(){
        return lotto;
    }

    public Lotto(){
        Set<Integer> tempSet = new HashSet<>();
        Random random = new Random();
        while(tempSet.size() < 6){
            tempSet.add(random.nextInt(44)+1);
        }
        int[] temp = Arrays.stream(tempSet.toArray(Integer[]::new))
                    .mapToInt(Integer::intValue)
                    .toArray(); 

        this.lotto = temp;
    }

    public Lotto(int[] lotto){
        this.lotto = lotto;
    }
}