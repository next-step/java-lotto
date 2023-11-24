package lotto;


import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    @DisplayName("로또 중복번호 생성 테스트")
    @Test
    public void 로또중복번호생성테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        assertThatThrownBy(() -> {
            lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 7)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 로또입니다.");
    }
}
