package lotto.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 한줄")
class SixBallTest {

    @RepeatedTest(100)
    @DisplayName("자동생성 로또6개 길이 확인")
    public void lengthTest() {
        SixBall sixBall = SixBall.get();

        long count = sixBall.stream().count();

        System.out.println(sixBall);
        assertThat(count).isEqualTo(6);
    }

    @RepeatedTest(100)
    @DisplayName("자동생성 로또6개 중복되지 않은 서로 다른값 확인")
    public void duplicateTest() {
        SixBall sixBall = SixBall.get();

        long count = sixBall.stream()
                .distinct()
                .count();

        System.out.println(sixBall);
        assertThat(count).isEqualTo(6);
    }

}