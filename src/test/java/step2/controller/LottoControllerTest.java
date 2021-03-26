package step2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    @DisplayName("LottoController 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoController lottoController = LottoController.newInstance();

        // then
        assertThat(lottoController).isNotNull();

    }
}