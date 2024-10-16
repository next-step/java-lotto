package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {
    private LottoCount lottoCount;

    @BeforeEach
    public void setUp() {
        this.lottoCount = new LottoCount(new LottoPrice(14000), 3);
    }

    @DisplayName("자동로또 갯수")
    @Test
    void 자동로또_갯수() {
        assertThat(lottoCount.getAutoCount()).isEqualTo(11);
    }

    @DisplayName("수동로또 갯수")
    @Test
    void 수동로또_갯수() {
        assertThat(lottoCount.getManualCount()).isEqualTo(3);
    }

    @DisplayName("전체로또 갯수")
    @Test
    void 전체로또_갯수() {
        assertThat(lottoCount.getTotalCount()).isEqualTo(14);
    }

    @DisplayName("입력한 로또 금액 보다 수동 로또 구매 횟수가 많을 시 에러")
    @Test
    void 로또에러() {
        assertThatThrownBy(() -> {
            new LottoCount(new LottoPrice(10000), 11);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
