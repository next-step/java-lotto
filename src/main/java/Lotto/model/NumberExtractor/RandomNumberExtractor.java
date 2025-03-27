package Lotto.model.NumberExtractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberExtractor implements NumberExtractor{
    @Override
    public List<Integer> extract(int size, int min, int max) {
        List<Integer> numberList = new ArrayList<>();
        for (int i=1; i<=max; i++){
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        return numberList.subList(0,size);
    }
}
