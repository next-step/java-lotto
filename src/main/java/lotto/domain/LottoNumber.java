package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private List<Integer> shuffledNumbers;
    private List<Integer> pickedNumbers;

    private static final int LOTTO_TOP_BOUND = 45;
    private static final int LOTTO_BOTTOM_BOUND = 1;
    private static final int COUNT_OF_PICK = 6;

    public LottoNumber() {
        shuffled();
        picked();
    }

    private void picked() {
        pickedNumbers = shuffledNumbers.subList(0, COUNT_OF_PICK);
        Collections.sort(pickedNumbers);
    }

    private void shuffled() {
        shuffledNumbers = new ArrayList<>();
        for (int i = LOTTO_BOTTOM_BOUND; i <= LOTTO_TOP_BOUND; i++) {
            shuffledNumbers.add(i);
        }

        Collections.shuffle(shuffledNumbers);
    }

    public LottoNumber(List<Integer> lottoNumbers) {
        this.pickedNumbers = lottoNumbers;
    }


    public String value() {
        return pickedNumbers.toString();
    }

    public long countOfMatch(LottoNumber winningLottoNumber) {

        return winningLottoNumber.pickedNumbers.stream()
                .filter(number -> this.pickedNumbers.contains(number))
                .count();

    }
}
