package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.LottoNumber.getAutoNumberList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 생성 중복 확인")
    void auto() {
        // given
        Lotto lotto = new Lotto().auto(getAutoNumberList());

        // expected
        assertThat(lotto.getNumberList()).isEqualTo(lotto.getNumberList().stream().distinct().collect(Collectors.toList()));
    }

    @Test
    @DisplayName("로또 랭크 확인")
    void rank() {
        // given
        List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> matchList = List.of(1, 2, 3, 10, 12, 13);

        // when
        Lotto lotto = new Lotto().auto(numberList);
        Lotto result = lotto.rank(matchList);

        // then
        assertThat(result.getRank()).isEqualTo(Rank.FIFTH);
    }
}
