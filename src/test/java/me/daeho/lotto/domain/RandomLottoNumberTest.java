package me.daeho.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumberTest {

    @DisplayName("서로 다른 랜덤한 값 6개 생성")
    @RepeatedTest(value = 100)
    void makeTest() {
        List<LottoNumber> numbers = RandomLottoNumber.make();
        assertThat(numbers.size()).isEqualTo(6);
    }
}