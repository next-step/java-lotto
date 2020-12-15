package lotto;

import lotto.domain.FixedNumberListGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCollectionTest {

    private LottoCollection lottoCollection;

    @BeforeEach
    void setUp() {
        lottoCollection = new LottoCollection(14, new FixedNumberListGenerator());
    }

    @Test
    void lottoCollectionTest() {
        assertThat(lottoCollection.getLottoNumbers(0)).containsExactlyInAnyOrder(8, 21, 23, 41, 42, 43);
        assertThat(lottoCollection.getLottoNumbers(1)).containsExactlyInAnyOrder(3, 5, 11, 16, 32, 38);
        assertThat(lottoCollection.getLottoNumbers(2)).containsExactlyInAnyOrder(7, 11, 16, 35, 36, 44);
        assertThat(lottoCollection.getLottoNumbers(8)).containsExactlyInAnyOrder(1, 3, 5, 14, 22, 45);
        assertThat(lottoCollection.getLottoNumbers(13)).containsExactlyInAnyOrder(3, 8, 27, 30, 35, 43);
    }

    @Test
    void getLottoCount() {
        assertThat(lottoCollection.getLottoCount()).isEqualTo(14);
    }
}