package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 LottoStatistic 테스트")
public class LottoStatisticComputerTest {

    private LottoStatisticComputer lottoStatisticComputer;
    @BeforeEach
    void initComputer() {
        lottoStatisticComputer = new LottoStatisticComputer();
    }


    @DisplayName("3개 당첨 통계 산출")
    @Test
    @MethodSource()
    void computeStatistic_three() {
        int result = lottoStatisticComputer.computeStatistic();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("4개 당첨 통계 산출")
    void computeStatistic_four() {
        int result = lottoStatisticComputer.computeStatistic();

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("5개 당첨 통계 산출")
    void computeStatistic_five() {
        int result = lottoStatisticComputer.computeStatistic();

        assertThat(result).isEqualTo(5);
    }

    @DisplayName("6개 당첨 통계 산출")
    void computeStatistic_six() {
        int result = lottoStatisticComputer.computeStatistic();

        assertThat(result).isEqualTo(6);
    }
}
