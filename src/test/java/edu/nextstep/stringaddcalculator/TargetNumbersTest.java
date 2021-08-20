package edu.nextstep.stringaddcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TargetNumbersTest {

    @Test
    void create() {
        // given
        String[] targetNumbersString = {"1", "2", "3"};

        // when
        TargetNumbers targetNumbers = TargetNumbers.from(targetNumbersString);

        // then
        assertThat(targetNumbers.value()).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void invalid(){
        // given
        String[] targetNumbersArr = {"-1", "2", "3"};

        // when, then
        assertThatThrownBy(() -> TargetNumbers.from(targetNumbersArr)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void sum() {
        // given
        TargetNumbers targetNumbers = TargetNumbers.from(new String[]{"1", "2", "3"});

        // when
        int result = targetNumbers.sum();

        // then
        assertThat(result).isEqualTo(6);
    }
}
