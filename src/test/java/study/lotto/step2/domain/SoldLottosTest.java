package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class SoldLottosTest {
    @Test
    @DisplayName("판매한 로또들의 선택 번호 반환")
    void selected_numbers() {
        // given
        SoldLottos soldLottos = new SoldLottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(11, 12, 13, 14, 15, 16))
        ));
        
        // when, then
        List<String> expectedSelectedNumbers = List.of(
                "[1, 2, 3, 4, 5, 6]",
                "[11, 12, 13, 14, 15, 16]"
        );

        assertThat(soldLottos.selectedNumbers()).isEqualTo(expectedSelectedNumbers);
    }
}