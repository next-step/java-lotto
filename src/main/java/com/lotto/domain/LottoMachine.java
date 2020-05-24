package com.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static List<Integer> availableLottoNumbers = Collections.unmodifiableList(makeAvailableLottoNumbers());

    private static List<Integer> makeAvailableLottoNumbers() {
        List<Integer> availableLottoNumbers = new ArrayList<>();
        IntStream.range(1, 46).forEach(availableLottoNumbers::add);
        return availableLottoNumbers;
    }

    public List<Lotto> buyLotto(Integer countOfLotto) {
        List<Lotto> extractedLotto = new ArrayList<>();
        IntStream.range(0, countOfLotto).forEach(i -> {
            List<Integer> extractedLottoNumbers = extractLottoNumbers();
            extractedLotto.add(new Lotto(extractedLottoNumbers));
        });

        return extractedLotto;
    }

    private List<Integer> extractLottoNumbers() {
        List<Integer> shuffledLottoNumbers = shuffleLottoNumbers();
        List<Integer> splitShuffledLottoNumbers = shuffledLottoNumbers.subList(0, 6);
        Collections.sort(splitShuffledLottoNumbers);
        return splitShuffledLottoNumbers;
    }

    private List<Integer> shuffleLottoNumbers() {
        List<Integer> copiedAvailableLottoNumbers = new ArrayList<>(LottoMachine.availableLottoNumbers);
        Collections.shuffle(copiedAvailableLottoNumbers);
        return copiedAvailableLottoNumbers;
    }
}
