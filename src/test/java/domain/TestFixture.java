package domain;

import java.util.HashSet;
import java.util.Set;

public class TestFixture {

    public static Lotto createLotto(Set<Integer> numbers) {
        Set<LottoNumber> result = new HashSet<>();
        for (Integer number : numbers) {
            result.add(new LottoNumber(number));
        }
        return new Lotto(result);
    }
}
