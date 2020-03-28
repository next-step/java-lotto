package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;

import java.util.Arrays;

public class Fixture {

    public static LottoBundle lottoBundle() {
        return new LottoBundle(Arrays.asList(lottoOne(), lottoTwo(), lottoThree()));
    }

    public static LottoBundle lottoBundleHasFiveLotto() {
        return new LottoBundle(Arrays.asList(lottoOne(), lottoTwo(), lottoThree(), lottoThree(), lottoThree()));
    }

    public static Lotto lottoOne() {
        return new Lotto("1, 2, 3, 4, 5, 6");
    }

    public static Lotto lottoTwo() {
        return new Lotto("13, 18, 23, 24, 30, 41");
    }

    public static Lotto lottoThree() {
        return new Lotto("23, 15, 4, 8, 43, 45");
    }
}
