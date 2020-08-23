package step2.domain;

import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> lottoNumber;
    private WinningPrice winningPrice;

    public Lotto(List<Integer> lottoNumber, WinningPrice winningPrice) {
        this.lottoNumber = lottoNumber;
        this.winningPrice = winningPrice;
    }

    public Lotto(List<Integer> lottoNumber) {
        this(lottoNumber, WinningPrice.OTHER);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public String getLottoValue() {
        return lottoNumber.stream()
                .map(numberValue -> numberValue.toString())
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public WinningPrice getWinningPrice() {
        return winningPrice;
    }
}
