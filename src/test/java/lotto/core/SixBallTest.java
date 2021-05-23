package lotto.core;

import lotto.util.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 한줄")
class SixBallTest {

    @RepeatedTest(100)
    @DisplayName("자동생성 로또6개 길이 확인")
    public void lengthTest() {
        SixBall sixBall = SixBall.valueOf();

        long count = sixBall.stream().count();

        System.out.println(sixBall);
        assertThat(count).isEqualTo(6);
    }

    @RepeatedTest(100)
    @DisplayName("자동생성 로또6개 중복되지 않은 서로 다른값 확인")
    public void duplicateTest() {
        SixBall sixBall = SixBall.valueOf();

        long count = sixBall.stream()
                .distinct()
                .count();

        System.out.println(sixBall);
        assertThat(count).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1",
        "1,2",
        "1,2,3",
        "1,2,3,4",
        "1,2,3,4,5",
        "1,2,3,4,5,6",
    })
    @DisplayName("정상적인 직접입력 로또 6개의 값")
    public void directTest(String source) {
        //Given
        int[] fixedBalls = StringUtils.csvToIntArray(source);

        //When
        SixBall sixBall = SixBall.valueOf(fixedBalls);

        //Then
        System.out.println(sixBall);
        assertThat(sixBall.stream().count()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1,1,1,1,1,1",
        "1,2,1,2,1,2",
        "1,2,3,1,2,3",
        "1,2,3,4,1,2,3,4",
        "1,2,3,4,5,1,2,3,4,5",
        "1,2,3,4,5,6,1,2,3,4,5,6",
    })
    @DisplayName("비정상 직접입력 로또 6개의 값")
    public void directTest2(String source) {
        //Given
        int[] fixedBalls = StringUtils.csvToIntArray(source);

        //When
        SixBall sixBall = SixBall.valueOf(fixedBalls);

        //Then
        System.out.println(sixBall);
        assertThat(sixBall.stream().count()).isEqualTo(6);
        assertThat(sixBall.stream().distinct().count()).isEqualTo(6);
    }
}