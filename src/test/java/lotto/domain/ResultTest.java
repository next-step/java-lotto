package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("로또 결과가 제대로 저장되는지 테스트")
    void saveResultTest1() {
        Result result = new Result();
        result.saveResult(1);
        result.saveResult(2);
        result.saveResult(3);
        result.saveResult(4);
        result.saveResult(5);
        result.saveResult(6);
        assertThat(result.getWinResultMap().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 당첨 결과 개수가 제대로 증가하는지 테스트")
    void saveResultTest2() {
        int matchCount = 1;
        Result result = new Result();
        result.saveResult(matchCount);
        result.saveResult(matchCount);
        assertThat(result.getWinResultMap().get(matchCount).getWinCount()).isEqualTo(2);
    }
}