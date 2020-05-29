package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.Operand;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankCountTest {

    @DisplayName("로또 등수별 증가된 카운트를 조회 할 수 있다.")
    @Test
    void findCount_LottoRank_CountValue() {
        LottoRankCount lottoRankCount = LottoRankCount.newInstance();

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            lottoRankCount.plusCount(lottoRank);
            assertThat(lottoRankCount.findCount(lottoRank)).isEqualTo(1);
        });
    }
}
