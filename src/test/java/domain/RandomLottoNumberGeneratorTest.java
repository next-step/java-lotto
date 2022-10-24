package domain;

import org.junit.jupiter.api.Test;
import util.RandomLottoNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoNumberGeneratorTest {

    @Test
    void 랜덤로또번호생성기의_generate는_로또번호를_생성한다() {
        assertThat(RandomLottoNumberGenerator.getInstance().generate()).isInstanceOf(LottoNumber.class);
    }
}
