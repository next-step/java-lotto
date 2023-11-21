package lotto;


import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호 확인 테스트")
    @Test
    public void 로또번호확인() {
        assertThatThrownBy(() -> {
            Set<LottoNumber> numbers = new HashSet<LottoNumber>();
            numbers.add(new LottoNumber(46));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
