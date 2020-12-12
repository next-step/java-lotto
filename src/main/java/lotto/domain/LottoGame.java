package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final long money;

    public LottoGame(long money) {
        this.money = money;
    }

    public void matchNumbers(String winningNumbers) {

        List<LottoNumber> lottoNumbers = Arrays.stream(winningNumbers.split(", "))
                .map(s -> new LottoNumber(Integer.parseInt(s))).collect(Collectors.toList());


    }
}
