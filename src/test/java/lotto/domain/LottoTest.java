package lotto.domain;

import lotto.util.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 생성 중복 확인")
    void getNumberList() {
        // given
        Lotto lotto = new Lotto(LottoNumber.getAutoNumberList());

        // expected
        assertThat(lotto.getNumberList()).isEqualTo(lotto.getNumberList().stream().distinct().collect(Collectors.toList()));
    }
}
