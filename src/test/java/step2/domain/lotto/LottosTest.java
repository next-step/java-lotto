package step2.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.ListNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    private List<Lotto> testLottos;

    @BeforeEach
    void setUp() {
        testLottos = new ArrayList<>();

        List<LottoNumber> testLottoNumbers = IntStream
                .range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        testLottos.add(Lotto.of(testLottoNumbers));
    }

    @DisplayName("Lottos 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        Lottos lottos = Lottos.of(testLottos);

        // then
        assertThat(lottos).isNotNull();
    }

    @DisplayName("Lottos 인스턴스가 쇼유한 값을 반환하는지에 대한 테스트")
    @Test
    void 반환() {

        // when
        Lottos lottos = Lottos.of(testLottos);
        List<Lotto> actual = lottos.getLottos();

        // then
        assertThat(actual).isEqualTo(testLottos);
    }


    @DisplayName("Lottos 인스턴스가 쇼유한 로또의 갯수를 반환하는지 테스트")
    @Test
    void 반환_크기() {
        // given
        int expected = testLottos.size();

        // when
        Lottos lottos = Lottos.of(testLottos);
        int actual = lottos.getLottosSize();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Lottos 인스턴스가 null값에 대해 예외처리 여부 테스트")
    @Test
    void 검증() {
        // given
        List<Lotto> nullLottos = null;


        // when
        assertThatThrownBy(()->{
            Lottos.of(nullLottos);
        }).isInstanceOf(ListNullPointerException.class)
                .hasMessageContaining("null인 리스트가 입력되었습니다.");
    }

    @DisplayName("Lottos 인스턴스가 쇼유한 값을 기준으로 비교를 반환하는지 테스트")
    @Test
    void 비교() {

        // when
        Lottos actualLottos = Lottos.of(testLottos);
        Lottos expectedLottos = Lottos.of(testLottos);

        // then
        assertThat(actualLottos).isEqualTo(expectedLottos);
    }


}