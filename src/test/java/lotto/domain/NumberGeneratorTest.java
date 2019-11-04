package lotto.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/05.
 */
class NumberGeneratorTest {

    private NumberGenerator generator;

    @BeforeEach
    void setUp() {
        // given
        generator = new NumberGenerator();
    }

    @DisplayName("숫자 생성")
    @Test
    void generate() {

        // given
        int size = 6;

        // when
        List<Integer> numbers = generator.generate(size);
        System.out.println(numbers);
        // then
        assertThat(numbers).hasSize(size);

    }
}