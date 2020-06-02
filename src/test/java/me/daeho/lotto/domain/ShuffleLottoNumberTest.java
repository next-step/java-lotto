package me.daeho.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ShuffleLottoNumberTest {
    @Test
    @DisplayName("서로 다른 랜덤한 값 6개 생성")
    void makeTest() {
        Set<LottoNumber> numbers = new HashSet<>(ShuffleLottoNumber.create(LottoNumber.availableNumbers())
                .make());
        assertThat(numbers.size()).isEqualTo(6);
    }
}