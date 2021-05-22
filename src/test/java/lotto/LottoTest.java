package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    private LottoNumber lottoNumber;
    private LottoNumberCreator lottoNumberCreator;
    private Lotto lotto;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottoNumberCreator = new LottoNumberCreator();
        lotto = lottoNumberCreator.makeLotto();
    }

    @DisplayName("로또 번호는 1~45이다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateLottoNumberTest(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoNumber = new LottoNumber(number);
        });
    }

    @DisplayName("로또는 6개의 서로다른 정수로 구성되어있다.")
    @Test
    void makeLottoTest() {
        assertThat(lotto.lottoTicketSize()).isEqualTo(6);
    }
}
