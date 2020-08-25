package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberGenerator {

    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;
    public static final int INT_ONE = 0;
    public static final int INT_SIX = 6;

    private List<Integer> lottoNumberCandidate;

    public NumberGenerator() {
        lottoNumberCandidate = new ArrayList<>();
        createLottoNumberCandidate();
    }

    public void createLottoNumberCandidate() {
        lottoNumberCandidate = IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> generate() {

        Collections.shuffle(lottoNumberCandidate);

        List<Integer> numList = new ArrayList<>(lottoNumberCandidate)
                .subList(INT_ONE, INT_SIX);

        return numList;
    }
}
