package step2.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.Lottos;
import step2.domain.lotto.LottoNumber;
import step2.exception.ListNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoExpressionResponseDtoTest {

    private Lottos testLottos;

    @BeforeEach
    void setUp() {
        List<LottoNumber> testLottoNumbers =
                IntStream
                .range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        Lotto testLotto = Lotto.of(testLottoNumbers);
        List<Lotto> testLottos = new ArrayList<>();
        testLottos.add(testLotto);
        this.testLottos = Lottos.newInstance(testLottos);
    }

    @DisplayName("LottoExpressionResponseDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        LottoExpressionResponseDto responseDto =
                LottoExpressionResponseDto.newInstance(testLottos);

        // then
        assertThat(responseDto).isNotNull();
    }

    @DisplayName("LottoExpressionResponseDto 인스턴스 null에 주입시 예외처리 발생 여부 테스트")
    @Test
    void 검증_Null() {
        // given
        Lottos nullLottos = null;

        // when and then
        assertThatThrownBy(()-> {
            LottoExpressionResponseDto.newInstance(nullLottos);
        }).isInstanceOf(ListNullPointerException.class)
                .hasMessageContaining("null인 리스트가 입력되었습니다.");
    }

    @DisplayName("LottoExpressionResponseDto가 소유한 값을 반환하는지에 대한 테스트")
    @Test
    void 반환() {
        // given
        LottoExpressionResponseDto responseDto =
                LottoExpressionResponseDto.newInstance(testLottos);

        // when
        Lottos actual = responseDto.getLottoList();

        // then
        assertThat(actual).isEqualTo(testLottos);
    }


}