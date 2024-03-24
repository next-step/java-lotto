package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @RepeatedTest(20)
    @DisplayName("1~45 사이의 6개의 숫자를 반환한다.")
    void getRandomLottoNumber() {

        List<Integer> randomLottoNumber = LottoNumberGenerator.getRandomLottoNumber();

        assertThat(randomLottoNumber).hasSize(6);
        randomLottoNumber.forEach(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }
}