package step2.domain;

import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private ArrayList<Integer> lottoNumber;
    private int winningCount;

    public Lotto(ArrayList<Integer> lottoNumber, int winningCount) {
        this.lottoNumber = lottoNumber;
        this.winningCount = winningCount;
    }
    public Lotto(ArrayList<Integer> lottoNumber) {
        this(lottoNumber, 0);
    }

    public ArrayList<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public String getLottoValue() {
        return lottoNumber.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(", ","[", "]"));
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getPrice() {
        return WinningPrice.getPriceWithWinningNumbers(winningCount);
    }
}
