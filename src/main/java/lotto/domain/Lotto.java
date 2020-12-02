package lotto.domain;

import java.util.Random;

public class Lotto {
    private int[] lotto;

    public int[] getLotto(){
        return lotto;
    }

    public Lotto(){
        int[] temp = new int[6];
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            temp[i] = random.nextInt(45); 
        }
        this.lotto = temp;
    }

    public Lotto(int[] lotto){
        this.lotto = lotto;
    }
}