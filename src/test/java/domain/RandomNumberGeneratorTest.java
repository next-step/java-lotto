package domain;

import org.junit.jupiter.api.Test;
import util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberGeneratorTest {

    @Test
    void 랜덤번호생성기의_generateNonZero는_경계값이_1보다_커야합니다() {
        assertThatThrownBy(() -> {
            RandomNumberGenerator.getInstance().generateNonZero(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤번호생성기의_generateNonZero는_1이상_지정한값_사이의_숫자를_생성한다() {
        RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.getInstance();

        // 랜덤번호생성기의 신뢰성을 위해 테스트를 몇번 수행해야하는지 모르겠음.
        for (int i = 2 ; i < 100; i++) {
            assertThat(randomNumberGenerator.generateNonZero(i))
                    .isGreaterThan(0)
                    .isLessThan(i);
        }
    }
}
