package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("로또 당첨 결과가 제대로 저장 및 증가하는지 테스트")
    void saveResultTest2() {
        int matchCount = 3;
        Result result = new Result();
        result.saveResult(matchCount);
        result.saveResult(matchCount);
        assertThat(result.getWinCount(matchCount)).isEqualTo(2);
    }

}