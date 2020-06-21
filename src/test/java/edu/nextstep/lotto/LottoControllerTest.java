package edu.nextstep.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoControllerTest {
    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController();
    }

    @DisplayName("로또 결과 확인")
    @ParameterizedTest
    @CsvSource(value = { "14000:1, 3, 16, 19, 43" }, delimiter = ':')
    void checkLottoTest(String money, String input) {
        lottoController.setupTest(Integer.valueOf(money), input);
    }
}
