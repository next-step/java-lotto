package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultProcessorTest {
    private static final WinningNumbers WINNING_NUMBERS =
            WinningNumbers.of(TestUtil.lottoFixture(1,2,3,4,5,6), LottoNumber.of(7, true));

    @Test
    @DisplayName("당첨결과 계산기는 당첨번호와 로또목록을 입력으로 받는고 WinningResult를 반환한다.")
    void create() {
        assertThat(new ResultProcessor().result(WINNING_NUMBERS, TestUtil.lottosFixture(TestUtil.lottoFixture(1,2,3,4,5,6))))
                .isInstanceOf(WinningResult.class);
    }
}
