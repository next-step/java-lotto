package com.lotto;

import com.lotto.domain.Lotto;
import com.lotto.domain.LottoAutoGenerator;
import com.lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoGeneratorTest {
    @Test
    void 로또생성_숫자개수() {
        Lotto lotto = LottoAutoGenerator.generate();
        assertThat(lotto.numbers().size()).isEqualTo(6);
    }

    @Test
    void 로또생성_오름차순정렬() {
        Lotto lotto = LottoAutoGenerator.generate();

        int preNumber = 0;
        for (LottoNumber number : lotto.numbers()) {
            assertThat(number.number()).isGreaterThan(preNumber);
        }
    }
}
