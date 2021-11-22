package lotto.domain;

import lotto.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {


    @DisplayName("generateLotto(int count) count 만큼 로또를 생성해서 반환한다.")
    @Test
    void generateTest() {
        LottoGenerator generator = () -> Lotto.create(Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6)
        ));

        assertThat(generator.generate()).isEqualTo(
                Lotto.create(Arrays.asList(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(6)
                ))
        );
    }

}
