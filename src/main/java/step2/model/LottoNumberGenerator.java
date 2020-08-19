package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberGenerator {
    private List<Integer> numberList = Stream.iterate(1, n -> n + 1)
            .limit(45)
            .collect(Collectors.toList());

    public String retrieveLottoNumberList() {
        return generateNumbersByRandom().toString();
    }

    private List<Integer> generateNumbersByRandom() {
        return sortFromShuffled();
    }

    private List<Integer> sortFromShuffled() {
        Collections.shuffle(numberList);
        List<Integer> extractNumbers = numberList.subList(0, 6);
        Collections.sort(extractNumbers);
        return extractNumbers;
    }


}
