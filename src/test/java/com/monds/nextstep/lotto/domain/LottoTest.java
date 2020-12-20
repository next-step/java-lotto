package com.monds.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void testCreateLotto() {
        // given
        String input = "1,2,3,4,5,6";
        // when
        Lotto lotto = Lotto.of(input);
        // then
        assertThat(lotto.toArray()).isEqualTo(new int[] {1, 2, 3, 4, 5, 6});
    }

    @Test
    @DisplayName("번호 매칭 개수")
    void testLottoCountOfMatchAll() {
        // given
        Lotto lotto = Lotto.of("1,2,3,4,5,6");
        Lotto winningLotto = Lotto.of("1,2,3,4,5,6");
        // when
        int countOfMatch = lotto.countOfMatch(winningLotto);
        // then
        assertThat(countOfMatch).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 배열 정렬해서 반환")
    void testToArrayInOrder() {
        // given
        Lotto lotto = Lotto.of("6,5,4,3,2,1");
        // when
        int[] numbers = lotto.toArray();
        // then
        assertThat(numbers).isEqualTo(new int[] {1, 2, 3, 4, 5, 6});
    }

    @Test
    @DisplayName("콤마가 아닌 구분자로 로또 생성 시 예외")
    void testCreateLottoWithOtherDelimiter() {
        assertLottoIllegalArgumentException("1:2:3:4:5:6");
    }

    @Test
    @DisplayName("로또 번호 개수가 6개 미만일 경우 예외")
    void testCreateLottoLessThanSix() {
        assertLottoIllegalArgumentException("1,2,3");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력된 값이 null 또는 empty 일 경우 예외")
    void testCreateLottoWithNullOrEmptyInput(String input) {
        assertLottoIllegalArgumentException(input);
    }

    void assertLottoIllegalArgumentException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(input));
    }
}
