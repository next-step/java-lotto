package step3.model;

import java.util.Set;

public class GlobalTest {

    public Lotto createLotto(int num1, int num2, int num3, int num4, int num5, int num6) {
        Set<LottoNumber> numbers = Set.of(
                new LottoNumber(num1),
                new LottoNumber(num2),
                new LottoNumber(num3),
                new LottoNumber(num4),
                new LottoNumber(num5),
                new LottoNumber(num6)
        );
        return new Lotto(numbers);
    }
}
