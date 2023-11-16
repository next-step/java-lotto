package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.*;
import step2.domain.dto.LottoRequest;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStoreTest {

    private final LottoStore lottoStore = new LottoStore(new LottoNumberGenerator());

    @Test
    @DisplayName("주어진 로또 넘버대로 로또를 발급할 수 있다")
    public void lottos_issuance() {
        LottoRequest request = new LottoRequest("1000", Arrays.asList("8, 21, 23, 41, 42, 43"));
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(8, 21, 23, 41, 42, 43));

        assertThat(lottoStore.lottos(request))
            .extracting(Lottos::lottos)
            .asList()
            .first()
            .isEqualTo(new Lotto(lottoNumbers));
    }

}
