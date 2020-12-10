package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {
    private int[] lotto;

    public Lotto(int[] lotto){
        this.lotto = lotto;
    }

    public Lotto(){
    }

    public Lotto createLotto(){
        Set<Integer> tempSet = new HashSet<>();
        Random random = new Random();
        while(tempSet.size() < 6){
            tempSet.add(random.nextInt(44)+1);
        }

        int[] temp = tempSet.stream()
        .mapToInt(Integer::intValue)
        .toArray(); 

        Lotto lotto = new Lotto(temp);
        return lotto;
    }

    public int[] getLotto(){
        return lotto;
    }
    
}
