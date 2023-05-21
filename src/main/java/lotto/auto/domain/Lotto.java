package lotto.auto.domain;

import lotto.auto.vo.WinNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static List<Integer> lottoEntireNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private List<Integer> lottoNumber = new ArrayList<>(6);

    public Lotto() {
        Collections.shuffle(lottoEntireNumber);
        this.lottoNumber = lottoEntireNumber.subList(0, 6);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumber;
    }

    public Win checkWin(WinNumber winNumbers) {
        int matchNumber = 0;
        for (Integer winNumber : winNumbers.getWinNumbers()) {
            matchNumber += isMatch(winNumber);
        }
        return Win.getWin(matchNumber);
    };

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
