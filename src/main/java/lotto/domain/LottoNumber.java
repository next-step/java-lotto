package lotto.domain;

import lotto.utils.AutoNumberList;

import java.util.List;

public class LottoBall {

    private int lottoNumber;

    public LottoBall(int number) {
        this.lottoNumber = number;
    }

    public static LottoBall getLottoNumbers() {
        return AutoNumberList.makeNumberList();
    }
}
