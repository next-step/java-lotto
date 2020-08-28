package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMatchResultTest {

    @DisplayName("LottoMatch 결과 저장 객체 생성")
    @Test
    void newInstance() {
        Map<Integer, Integer> matchResult = new HashMap<>();
        double profit = 0.1;

        LottoMatchResult lottoMatchResult = new LottoMatchResult(matchResult, profit);

        assertThat(lottoMatchResult).isNotNull();
    }
}
