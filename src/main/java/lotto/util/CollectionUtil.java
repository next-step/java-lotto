package lotto.util;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtil {

    public static List<Number> createRandomNumbers() {
        List<Number> randomNumbers = new ArrayList<>();
        for(int i=0;i <6;i++){
            Number randomNumber = new Number(RandomUtil.getRandomNumber());
            randomNumbers.add(randomNumber);
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers;
    }


}
