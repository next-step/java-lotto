package com.monds.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("중복 없는 로또 생성")
    void testGenerateLotto() {
        Lotto lotto = LottoGenerator.shuffleAndGet();

        Set<Integer> numbers = new HashSet<>();
        for (Integer number : lotto.toArray()) {
            numbers.add(number);
        }

        assertThat(numbers.size()).isEqualTo(6);
    }
}
