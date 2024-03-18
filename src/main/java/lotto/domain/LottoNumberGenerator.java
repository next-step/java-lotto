package lotto.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoNumberGenerator {

    private static final Random RANDOM = new Random();

    public static Set<Integer> generate() {
        Set<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < 6) {
            int randomNumber = RANDOM.nextInt(45) + 1;// 1부터 45 사이의 난수 생성
            numberSet.add(randomNumber);
        }

        return numberSet;
    }

}
