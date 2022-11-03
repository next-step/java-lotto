package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 모두 일치")
    void matches_all() {
        Lotto lotto = LottoTestUtil.toLottoNumberList(1, 10, 13, 16, 18, 20);
        Prize result = lotto.matches(LottoTestUtil.toLottoNumberList(1, 10, 13, 16, 18, 20), new LottoNumber(45));
        assertThat(result).isEqualTo(Prize.SIX);
    }

    @Test
    @DisplayName("로또 번호 5개 일치, 보너스 일치")
    void matches_5_bonus() {
        Lotto lotto = LottoTestUtil.toLottoNumberList(1, 10, 13, 15, 18, 45);
        Prize result = lotto.matches(LottoTestUtil.toLottoNumberList(1, 10, 13, 15, 18, 20), new LottoNumber(45));
        assertThat(result).isEqualTo(Prize.FIVE_BONUS);
    }

    @Test
    @DisplayName("로또 번호 5개 일치")
    void matches_5() {
        Lotto lotto = LottoTestUtil.toLottoNumberList(1, 10, 13, 16, 18, 20);
        Prize result = lotto.matches(LottoTestUtil.toLottoNumberList(1, 10, 13, 15, 18, 20), new LottoNumber(45));
        assertThat(result).isEqualTo(Prize.FIVE);
    }

    @Test
    @DisplayName("로또 번호 4개 일치")
    void matches_4() {
        Lotto lotto = LottoTestUtil.toLottoNumberList(1, 10, 13, 16, 18, 20);
        Prize result = lotto.matches(LottoTestUtil.toLottoNumberList(1, 10, 11, 15, 18, 20), new LottoNumber(45));
        assertThat(result).isEqualTo(Prize.FOUR);
    }

    @Test
    @DisplayName("로또 번호 3개 일치")
    void matches_3() {
        Lotto lotto = LottoTestUtil.toLottoNumberList(1, 10, 13, 16, 18, 20);
        Prize result = lotto.matches(LottoTestUtil.toLottoNumberList(1, 10, 11, 15, 17, 20), new LottoNumber(45));
        assertThat(result).isEqualTo(Prize.THREE);
    }

    @Test
    @DisplayName("로또 번호 1개 일치, 상금 없음")
    void matches_1() {
        Lotto lotto = LottoTestUtil.toLottoNumberList(1, 9, 13, 16, 18, 20);
        Prize result = lotto.matches(LottoTestUtil.toLottoNumberList(1, 10, 11, 15, 17, 20), new LottoNumber(45));
        assertThat(result).isEqualTo(Prize.NONE);
    }

    @Test
    @DisplayName("범위보다 큰 숫자의 로또 번호 입력 불가")
    void big_number() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTestUtil.toLottoNumberList(1, 10, 13, 16, 18, LottoNumber.MAX + 1))
                .withMessageContaining("사이의 값이어야 합니다");
    }

    @Test
    @DisplayName("범위보다 작은 숫자의 로또 번호 입력 불가")
    void small_number() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTestUtil.toLottoNumberList(LottoNumber.MIN - 1, 10, 13, 16, 18, 40))
                .withMessageContaining("사이의 값이어야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = "1,2,3,4,5 1,2,3,4,5,6,7 1,1,1,1,1,1", delimiter = ' ')
    @DisplayName("로또 번호는 서로 다른 6개로 입력되어야 함")
    void number_count(String input) {
        List<LottoNumber> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageContaining("개 선택되어야 합니다.");
    }
}
