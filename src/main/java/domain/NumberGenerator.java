package domain;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {

    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;
    public static final int INT_ZERO = 0;
    public static final int INT_SIX = 6;

    private List<Integer> lottoNumberCandidate;

    public NumberGenerator() {
        lottoNumberCandidate = createLottoNumberCandidate();
    }

    private List<Integer> createLottoNumberCandidate() {
        return IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
                .boxed().collect(Collectors.toList());
    }

    public Set<Integer> generate() {
        Collections.shuffle(lottoNumberCandidate);

        List<Integer> numList = new ArrayList<>(lottoNumberCandidate)
                .subList(INT_ZERO, INT_SIX);

        Set<Integer> set = new HashSet<>(numList);

        return set;
    }
}
