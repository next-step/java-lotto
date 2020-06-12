package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.Formula;
import step1.FormulaSplitter;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchResultTest {

    @DisplayName("정적 생성자는 null을 입력하면 예외 발생")
    @Test
    void createExceptionThrown() {
        assertThatThrownBy(() -> MatchResult.create(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨된 로또가 없으면 0을 반환")
    @Test
    void findResult() {
        MatchResult matchResult = MatchResult.create(new ArrayList<>());

        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            assertThat(matchResult.findResult(lottoRank)).isEqualTo(0);
        });
    }
}
