package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Lotto;
import step3.model.LottoMake;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step3.utils.CalculateUtils.EACH_LOTTO_PRICE;

public class LottoMakeTest {

    @ParameterizedTest
    @CsvSource(value = {"12000:12", "14000:14", "2000:2", "1000:1", "5000:5"}, delimiter = ':')
    @DisplayName("지불한 가격만큼 로또를 생성한다.")
    void lottoMakeTest(int lottoPayPrice, int expectedMakeCount) {
        LottoMake lottoMake = new LottoMake(lottoPayPrice);
        List<Lotto> lottos = lottoMake.makeLottos();

        assertThat(lottos.size()).isEqualTo(expectedMakeCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {12450, 35400, 2140, 1240, 6500, 98123, -1000, -24340})
    @DisplayName("지불한 가격이 0으로 떨어지지 않거나 음수로 나올 경우 예외를 발생시킨다.")
    void lottoMakeInvalidPayPriceTest(int lottoPayPrice) {
        LottoMake lottoMake = new LottoMake(lottoPayPrice);
        assertThatThrownBy(lottoMake::makeLottos)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액을 잘못 입력 하였습니다. 로또 한장의 가격은 " + EACH_LOTTO_PRICE + "원 입니다.");
    }
}
