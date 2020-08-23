package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGenerator {

    public static final int FIRST_NUMBER = 1;
    public static final int LAST_NUMBER = 45;

    List<Integer> numList;
    List<Integer> lottoNumberCandidate;

    public NumberGenerator() {
        numList = new ArrayList<>();
        lottoNumberCandidate = new ArrayList<>();
    }

    public void createLottoNumberCandidate() {
        lottoNumberCandidate = IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> generate() {

        Collections.shuffle(lottoNumberCandidate);
        numList = new ArrayList<>();

        for (int i = 0; i < LottoGames.LOTTO_NUMBER; i++) {
            numList.add(lottoNumberCandidate.get(i));
        }

        return numList;
    }
}
