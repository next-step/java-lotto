package step2.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.Lottos;
import step2.domain.lotto.LottoNumber;
import step2.dto.LottoCreationRequestDto;
import step2.dto.LottoExpressionResponseDto;
import step2.strategy.LottoShuffleStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    private LottoCreationRequestDto creationRequestDto;
    private LottoShuffleStrategy lottoShuffleStrategy;
    private Lottos testLottos;

    @BeforeEach
    void setUp() {
        creationRequestDto = LottoCreationRequestDto.newInstance(1000);
        lottoShuffleStrategy = lottoNumbers -> Collections.sort(lottoNumbers);
        List<LottoNumber> lottoNumbers = IntStream
                .range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        testLottos = Lottos.newInstance();
        testLottos.add(Lotto.of(lottoNumbers));
    }

    @DisplayName("LottoController 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoController lottoController = LottoController.newInstance(lottoShuffleStrategy);

        // then
        assertThat(lottoController).isNotNull();

    }

    @DisplayName("LottoController 인스턴스의 로또 생성 로직과 LottoExpressionResponseDto 반환 테스트")
    @Test
    void 로또_생성_및_반환() {

        // given
        LottoController lottoController = LottoController.newInstance(lottoShuffleStrategy);

        // when
        LottoExpressionResponseDto actual = lottoController.getExpressionLottoList(creationRequestDto);

        // then
        assertThat(actual).isNotNull();
    }

}