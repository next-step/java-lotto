package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberGeneratorTest {

    @Test
    @DisplayName("6개의 랜덤한 숫자를 반환하는지 확인하는 테스트")
    void getSizList() {
        // given
        AutoLottoNumberGenerator autoLottoMaker = new AutoLottoNumberGenerator();
        // when
        List<LottoNumber> result = autoLottoMaker.makeLottoNumberList();
        // then
        assertThat(result).hasSize(6);
    }
}