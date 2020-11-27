package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoWinningNumsTest {

    @Test
    @DisplayName("입력값이 올바른 경우 인스턴스 생성")
    public void create_lotto_winning_nums() {

        LottoWinningNums nums = new LottoWinningNums("1, 2, 3, 4, 5, 6");

        assertThat(
                nums.getWinningLotto()
                        .equals(
                                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                        )
        ).isTrue();

    }

    @Test
    @DisplayName("입력값이 많은 경우 인스턴스 생성 실패")
    public void fail_lotto_winning_nums() {

        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> new LottoWinningNums("1, 2, 3, 4, 5, 6, 7").getWinningLotto()
                );
    }

    @Test
    @DisplayName("숫자로 변환할 수 없는 입력값인 경우")
    public void non_number_string_input() {

        assertThatThrownBy(
                        () -> new LottoWinningNums("일,이,삼,사,오,육")
                ).isInstanceOf(NumberFormatException.class);
    }

}