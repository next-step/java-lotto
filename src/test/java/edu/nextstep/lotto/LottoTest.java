package edu.nextstep.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
