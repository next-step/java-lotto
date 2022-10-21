package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStorageTest {

    @Test
    @DisplayName("입력한 수량대로 로또를 생성한다")
    void create() {
        final int purchaseLottoCount = 14;

        LottoStorage lottoStorage = LottoStorage.create(purchaseLottoCount);
        List<Lotto> lottoList = lottoStorage.copy();

        assertThat(lottoList).hasSize(purchaseLottoCount);
    }
}