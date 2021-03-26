package step2.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto.Lotto;
import step2.domain.Lotto.LottoList;
import step2.domain.Lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoExpressionResponseDtoTest {

    private LottoList testLottoList;

    @BeforeEach
    void setUp() {
        List<LottoNumber> testLottoNumbers =
                IntStream
                .range(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        Lotto testLotto = Lotto.newInstance(testLottoNumbers);
        List<Lotto> testLottos = new ArrayList<>();
        testLottos.add(testLotto);
        testLottoList = LottoList.newInstance(testLottos);
    }

    @Disabled("LottoExpressionResponseDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        LottoExpressionResponseDto responseDto = LottoExpressionResponseDto
                .newInstance(testLottoList);

        // then
        assertThat(responseDto).isNotNull();

    }
}