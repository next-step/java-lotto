package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @ParameterizedTest
    @DisplayName("정해진 횟수만큼 로또가 구매되는지 테스트")
    @CsvSource(value = {"3, 5, 11, 16, 32, 38:7, 11, 16, 35, 36, 44:23, 25, 33, 36, 39, 41}|3"}, delimiter = '|')
    void lottoCountTest(String lottoString, int expect) {
        String[] lottoArray = lottoString.split(":");
        Lottos lottos = new Lottos(lottoArray);
        assertThat(lottos.size()).isEqualTo(expect);
    }
}
