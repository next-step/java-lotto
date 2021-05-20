package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    private List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)
    );
    private Money money;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        money = new Money(5000);
        lottoGenerator = new LottoGenerator(money);
    }

    @DisplayName("구매한 로또를 리턴한다")
    @Test
    void generatePurchasedLottos() {
        assertThat(lottoGenerator.getPurchasedLottos().size()).isEqualTo(5);
    }

}
