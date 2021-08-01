package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private List<Integer> shuffledNumbers;
    private List<Integer> pickedNumbers;

    public LottoNumber() {
        shuffled();
        picked();
    }

    private void picked() {
        pickedNumbers = shuffledNumbers.subList(0, 6);
        Collections.sort(pickedNumbers);
    }

    private void shuffled() {
        shuffledNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
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
