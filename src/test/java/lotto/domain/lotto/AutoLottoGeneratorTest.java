package lotto.domain.lotto;

import lotto.domain.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {

    @DisplayName("자동 로또 발급기는 중복되지 않는 6개의 숫자를 포함한 로또를 발급한다.")
    @Test
    void ticket() {
        final Lotto lotto = AutoLottoGenerator.ticket();
        final List<LottoNumber> lottoNumbers = lotto.numbers();

        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(new HashSet<>(lottoNumbers).size()).isEqualTo(6);
    }

    @DisplayName("자동 로또 발급기는 입력 받은 개수 만큼의 로또를 발급한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void tickets(int amount) {
        final Lottos lottos = AutoLottoGenerator.tickets(new Amount(amount));
        assertThat(lottos.size()).isEqualTo(amount);
    }


}
