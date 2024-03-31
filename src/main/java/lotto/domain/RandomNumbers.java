package lotto.domain;

import java.util.*;

public class RandomNumbers {
    private final static int LOTTO_BOUND_NUMBER = 45;
    private final static int LOTTO_NUMBER_LIMIT = 5;
    List<Integer> lottoNumbers = new ArrayList<>();

    public RandomNumbers() {
        HashSet<Integer> randomNumber = new HashSet<>();
        Random rand = new Random();

        while (randomNumber.size() < LOTTO_NUMBER_LIMIT) {
            int number = rand.nextInt(LOTTO_BOUND_NUMBER) ;
            randomNumber.add(number);
        }
        lottoNumbers =  new ArrayList<>(randomNumber);
        Collections.shuffle(lottoNumbers);
    }
}
