package lotto.auto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Lotto {
    List<Integer> lottoEntireNumber = new ArrayList<>();
    private List<Integer> lottoNumber = new ArrayList<>(6);

    public Lotto() {
        List<Integer> result = createLottoNumber();
        Collections.shuffle(result);
        this.lottoNumber = result.subList(0, 6);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumber;
    }

    public Win checkWin(List<Integer> winNumbers) {
        int matchNumber = 0;
        for (Integer winNumber : winNumbers) {
            matchNumber += isMatch(winNumber);
        }
        return Win.getWin(matchNumber);
    };

    private List<Integer> createLottoNumber() {
        for(int i : IntStream.rangeClosed(1, 45).toArray()) {
            lottoEntireNumber.add(i);
        }
        return lottoEntireNumber;
    }

    private int isMatch(Integer win) {
        if(lottoNumber.contains(win)) {
            return 1;
        };
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
