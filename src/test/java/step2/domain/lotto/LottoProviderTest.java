package step2.domain.lotto;

import step2.LottoProvider;
import step2.domain.LottoRequest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

public class LottoProviderTest {

    @Test
    @DisplayName("로또 제공 테스트")
    void provideLottoTest() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumbers(asList(1, 10, 20, 30, 40, 45)));

        LottoRequest lottoRequest = new LottoRequest(3000, lottoNumbers);
        List<LottoNumbers> lotto = LottoProvider.provideLotto(lottoRequest);

        assertThat(lotto).isNotNull();
        assertThat(lotto.size()).isEqualTo(3);
    }
}
