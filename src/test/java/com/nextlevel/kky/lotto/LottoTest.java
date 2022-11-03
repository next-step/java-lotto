package com.nextlevel.kky.lotto;

import com.nextlevel.kky.lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "2,3,4,5,2,1", "45,56,56,12,2,3"})
    @DisplayName("비정상적인 입력에 대하여 예외를 발생시킨다.")
    public void createLottoByWrongArgument(String input) {
        List<Integer> numbers = Arrays
                .stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(numbers));
    }
}
