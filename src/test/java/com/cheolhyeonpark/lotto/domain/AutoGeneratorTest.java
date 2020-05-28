package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class AutoGeneratorTest {

    private final AutoGenerator autoGenerator = new AutoGenerator();

    @Test
    public void generateSixNumbers() {
        List<Integer> pickedNumbers = autoGenerator.generate();
        assertThat(pickedNumbers.size()).isEqualTo(6);
    }
}