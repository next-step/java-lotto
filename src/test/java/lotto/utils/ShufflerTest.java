package lotto.utils;

import lotto.domain.LottoNo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    void getLottoNos_range() {
        List<Executable> executables = new LinkedList<>();
        for (int num : shuffler.getIntegers(100)) {
            executables.add(() -> {
                assertThat(checkLottoNo(num))
                        .isTrue();
            });
        }
        Assertions.assertAll(executables);
    }

    @Test
    @DisplayName("중복된 번호가 있으면 안된다.")
    void getLottoNos_contains() {
        List<Executable> executables = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : shuffler.getIntegers(100)) {
            executables.add(() -> {
                assertThat(set.contains(num))
                        .isFalse();
                set.add(num);
            });
        }
        Assertions.assertAll(executables);
    }
}
