package study.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.domain.generator.NumberGenerator;
import study.domain.generator.impl.AutoNumberGenerator;

public class TestLottery {

    private NumberGenerator generator;
    private Lottery lotto;

    @BeforeEach
    void setUp() {
        generator = new AutoNumberGenerator();
        lotto = new Lottery(generator);
    }
    

    @Test
    @DisplayName("Lottery 객체 - 생성 테스트")
    public void test_lottery() {
        assertThat(lotto.getLottery().size())
            .isEqualTo(6);
    }


    @Test
    @DisplayName("Lottery 객체 - 당첨번호 없이 일치여부 테스트")
    public void test_lottery_win_fail_match_count() {
        assertThatThrownBy(() -> lotto.getMatchCount())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨 번호 확인이 안되었습니다");
    }


    @Test
    @DisplayName("Lottery 객체 - 당첨번호 전체 일치 테스트")
    public void test_lottery_win_match_count() {
        List<Integer> winNumbers = lotto.getLottery();
        lotto.setWinNumbers(winNumbers);

        assertThat(lotto.getMatchCount())
            .isEqualTo(6);
    }

}
