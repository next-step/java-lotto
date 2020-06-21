package edu.nextstep.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class LottoTest {
    private Lotto lotto;

    @DisplayName("로또 생성 테스트 준비")
    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @DisplayName("로또 1개 생성")
    @Test
    void generatorTest() {
        List lottery = lotto.makeLotto();
        ResultView.printLotto(lottery);
    }

    @DisplayName("로또 결과 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void checkLottoTest(String input) {
        List lottery = lotto.makeLotto();
        ResultView.printLotto(lottery);

        assertThat(lotto.checkLotto(input.split(", ")))
                .isBetween(0, 6);

    }

}
