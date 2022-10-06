package lotto.domain.fixture;

import lotto.domain.LottoNumber;

import java.util.List;

public class Fixture {
    public static List<LottoNumber> getLottoNumbersFixture(int num1, int num2, int num3, int num4, int num5, int num6) {
        return List.of(LottoNumber.of(num1),
                LottoNumber.of(num2),
                LottoNumber.of(num3),
                LottoNumber.of(num4),
                LottoNumber.of(num5),
                LottoNumber.of(num6));
    }
}
