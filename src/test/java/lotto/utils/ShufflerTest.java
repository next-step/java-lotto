package lotto.utils;

import lotto.asset.LottoConst;
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

    Shuffler shuffler;

    @BeforeEach
    void setUp() {
        shuffler = Shuffler.getInstance();
    }

    @Test
    @DisplayName("6개의 번호들을 반환해야 한다.")
    void getLottoNos_size() {
        assertThat(shuffler.getLottoNos().length)
                .isEqualTo(LottoConst.NUM_OF_LOTTO_NO);
    }

    private boolean checkLottoNo(int no) {
        return no >= LottoConst.NO_MIN
                && no <= LottoConst.NO_MAX;
    }

    @Test
    @DisplayName("1과 45 사이의 번호들을 반환해야 한다.")
    void getLottoNos_range() {
        List<Executable> executables = new LinkedList<>();
        for (int no : shuffler.getLottoNos()) {
            executables.add(() -> {
                assertThat(checkLottoNo(no))
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
        for (int no : shuffler.getLottoNos()) {
            executables.add(() -> {
                assertThat(set.contains(no))
                        .isFalse();
                set.add(no);
            });
        }
        Assertions.assertAll(executables);
    }
}
