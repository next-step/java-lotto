package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = 5)
    @DisplayName("로또 리스트 개수 맞게 생성하는지")
    public void generateLottoList(int lottoCount) {
        assertThat(Lottos.generateLottoList(lottoCount).getLottoList().size()).isEqualTo(lottoCount);
    }
}
