package lotto.domain;

import exception.CustomException;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.StringLottoNumbers;
import lotto.exception.LottoErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {

    private static final List<String> MANUAL_LOTTO_LIST =
            List.of("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7");

    @Test
    @DisplayName("로또 판매점 생성 테스트")
    void createLottoStore() {
        LottoStore lottoStore =
                new LottoStore(14000, MANUAL_LOTTO_LIST);

        List<Lotto> lottos = MANUAL_LOTTO_LIST.stream()
                .map(StringLottoNumbers::toLotto)
                .collect(Collectors.toList());

        assertThat(lottoStore.getLotto()).containsAll(lottos);
    }

    @Test
    @DisplayName("구입금액보다 수동 로또 수가 많으면 실패한다")
    void lottoManualNumberOutOfLange() {
        assertThatThrownBy(() -> new LottoStore(1000, MANUAL_LOTTO_LIST))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_MANUAL_NUMBER_OUT_OF_LANGE.getMessage());
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateYield() {
        LottoStore lottoStore = new LottoStore(14000, MANUAL_LOTTO_LIST);
        float yield = lottoStore.calculateYield(14000L);
        assertThat(yield).isEqualTo(1);
    }
}
