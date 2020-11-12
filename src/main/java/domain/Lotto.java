package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());
    private List<Integer> sixNumbers;

    private Lotto() {
        Collections.shuffle(lottoNumbers);
        sixNumbers = lottoNumbers.subList(0,6);
        Collections.sort(sixNumbers);
    }

    public Lotto(List<Integer> numbers) {
        if(numbers.size() == 0){
            new Lotto();
        }
        sixNumbers = numbers;
    }
}
