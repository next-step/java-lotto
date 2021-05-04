package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @ParameterizedTest
    @ValueSource(ints = {14000})
    void buyLotto(int money) {
        assertThat(lotto.buyLotto(money)).isEqualTo(14);
    }

    @Test
    void getRandomNumber(){
        assertThat(lotto.getRandomNumber()).isBetween(1, 45);
    }

    @RepeatedTest(value = 6)
    void createLotto(RepetitionInfo repetitionInfo){
        assertThat(lotto.createLotto().get(repetitionInfo.getCurrentRepetition() - 1)).isBetween(1, 45);
    }

}
