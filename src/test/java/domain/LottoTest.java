package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 총 몇 개가 일치하는지 테스트")
    void checkLottoNumbers() {
        //given
        Lotto lotto1 = Lotto.create(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        Lotto lotto2 = Lotto.create(Stream.of(5, 6, 7, 8, 9, 10)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        //when,then
        assertThat(lotto1.countMatch(lotto2)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 번호가 하나도 일치하지 않는지 테스트")
    void checkNonLottoNumbers() {
        //given
        Lotto lotto1 = Lotto.create(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        Lotto lotto2 = Lotto.create(Stream.of(7, 8, 9, 10, 11, 12)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        //when,then
        assertThat(lotto1.countMatch(lotto2)).isEqualTo(0);
    }
}