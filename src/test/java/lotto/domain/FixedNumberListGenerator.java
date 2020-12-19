package lotto.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class FixedNumberListGenerator implements NumberListGenerator {

    private final Queue<Set<LottoNumber>> numberList;

    protected static Set<LottoNumber> convertNumberSet(int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public FixedNumberListGenerator() {
        numberList = new LinkedList<>();
        numberList.add(convertNumberSet(8, 21, 23, 41, 42, 43));
        numberList.add(convertNumberSet(3, 5, 11, 16, 32, 38));
        numberList.add(convertNumberSet(7, 11, 16, 35, 36, 44));
        numberList.add(convertNumberSet(1, 8, 11, 31, 41, 42));
        numberList.add(convertNumberSet(13, 14, 16, 38, 42, 45));
        numberList.add(convertNumberSet(7, 11, 30, 40, 42, 43));
        numberList.add(convertNumberSet(2, 13, 22, 32, 38, 45));
        numberList.add(convertNumberSet(23, 25, 33, 36, 39, 41));
        numberList.add(convertNumberSet(1, 3, 5, 14, 22, 45));
        numberList.add(convertNumberSet(5, 9, 38, 41, 43, 44));
        numberList.add(convertNumberSet(2, 8, 9, 18, 19, 21));
        numberList.add(convertNumberSet(13, 14, 18, 21, 23, 35));
        numberList.add(convertNumberSet(17, 21, 29, 37, 42, 45));
        numberList.add(convertNumberSet(3, 8, 27, 30, 35, 43));
    }

    @Override
    public Set<LottoNumber> generate() {
        return numberList.poll();
    }
}
