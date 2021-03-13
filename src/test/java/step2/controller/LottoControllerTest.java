package step2.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lottos;
import step2.dto.LottosDto;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void init() {
        lottoController = new LottoController();
    }

    @DisplayName("뷰로 이동할 전송객체를 만든다.")
    @Test
    void createDto() {
        //given
        Lottos lotto = new Lottos();
        Lottos resultLottos = lotto.createLottoList(5);

        //when
        LottosDto lottosDto = lottoController.createLottosDto(resultLottos);

        //then
        assertThat(lottosDto.equals(lottosDto)).isTrue();
    }

}