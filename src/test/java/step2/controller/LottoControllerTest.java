package step2.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.dto.LottoCreationRequestDto;
import step2.dto.LottoExpressionResponseDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    private LottoCreationRequestDto creationRequestDto;

    @BeforeEach
    void setUp() {
        creationRequestDto = LottoCreationRequestDto.newInstance(1000);
    }

    @DisplayName("LottoController 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoController lottoController = LottoController.newInstance();

        // then
        assertThat(lottoController).isNotNull();

    }

    @DisplayName("LottoController 인스턴스의 로또 생성 로직과 LottoExpressionResponseDto 반환 테스트")
    @Test
    void 로또생성_및_반환() {

        // given
        LottoController lottoController = LottoController.newInstance();

        // when
        LottoExpressionResponseDto actual = lottoController.generateLottoList(creationRequestDto);

        // then
        assertThat(actual).isNotNull();
    }
}