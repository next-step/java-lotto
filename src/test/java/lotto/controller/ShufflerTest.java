package lotto.controller;

import lotto.domain.LottoNo;
import lotto.exception.BadMinMaxException;
import lotto.exception.BadShuffleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ShufflerTest {

    private static final int min = 1;
    private static final int max = 45;
    private Shuffler shuffler;

    @BeforeEach
    void setUp() {
        shuffler = new Shuffler(min, max);
    }

    private boolean checkLottoNo(int no) {
        return no >= LottoNo.MIN
                && no <= LottoNo.MAX;
    }

    @Test
    @DisplayName("min 과 max 사이의 번호들을 반환해야 한다.")
    void getIntegers_range() {
        List<Executable> executables = new LinkedList<>();
        for (int num : shuffler.getIntegers(max)) {
            executables.add(() -> {
                assertThat(checkLottoNo(num))
                        .isTrue();
            });
        }
        Assertions.assertAll(executables);
    }

    @Test
    @DisplayName("중복된 번호가 있으면 안된다.")
    void getIntegers_contains() {
        List<Executable> executables = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : shuffler.getIntegers(max)) {
            executables.add(() -> {
                assertThat(set.contains(num))
                        .isFalse();
                set.add(num);
            });
        }
        Assertions.assertAll(executables);
    }

    @ParameterizedTest
    @DisplayName("min 이 max 보다 크면, BadMinMaxException 이 발생한다.")
    @CsvSource(value = {"2$1", "-5$-2"}, delimiter = '$')
    void constructor_min_max_exception(int min, int max) {
        assertThatExceptionOfType(BadMinMaxException.class)
                .isThrownBy(() -> new Shuffler(min, max));
    }

    @ParameterizedTest
    @DisplayName("size 가 범위 밖에 있다면, BadShuffleException 이 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    void getIntegers_size(int size) {
        assertThatExceptionOfType(BadShuffleException.class)
                .isThrownBy(() -> shuffler.getIntegers(size));
    }
}
