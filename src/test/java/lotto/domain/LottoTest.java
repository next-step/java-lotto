package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("중복된 번호로 로또를 생성하면 예외가 발생하는 테스트")
    void testLottoFromStringWithDuplicateNumbers() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto("1, 2, 3, 3, 5, 6");
        });
    }

    @Test
    @DisplayName("로또 번호를 문자열로 반환하는 테스트")
    void testFindLotto() {
        // given
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");

        // when
        String result = lotto.findLotto();

        // then
        assertAll(
                () -> assertNotNull(result),
                () -> assertTrue(result.startsWith("[")),
                () -> assertTrue(result.endsWith("]"))
        );
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수를 반환하는 테스트")
    void testCalculateMatchCount() {
        // given
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto winningNumbers = new Lotto("1, 2, 3, 10, 11, 12");

        // when
        long matchCount = lotto.calculateMatchCount(winningNumbers);

        // then
        assertThat(matchCount).isEqualTo(3);
    }
}
