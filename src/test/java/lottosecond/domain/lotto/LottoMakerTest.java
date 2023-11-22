package lottosecond.domain.lotto;

import lottosecond.domain.Money;
import lottosecond.domain.StringToLottoConvertor;
import lottosecond.testutil.TestShuffler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMakerTest {

    @DisplayName("lottoCount 의 수동 로또 개수와 입력받은 수동 로또 번호의 크기가 다르면 에러가 발생합니다.")
    @Test
    void notSameSize() {
        // given
        TotalLottoCount lottoCount = new TotalLottoCount(new Money(4000), 3);
        LottoMaker lottoMaker = new LottoMaker(lottoCount);
        // when
        // then
        assertThatThrownBy(() -> lottoMaker.makeTotalLottos(new TestShuffler(), new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 개수 입력과 실제 로또 번호 입력 개수가 다릅니다.");
    }

}