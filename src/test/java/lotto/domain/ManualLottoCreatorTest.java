package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoCreatorTest {
    private List<String> lottoNumbers;

    @BeforeEach
    void setup() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add("1, 2, 3, 4, 5, 6");
        lottoNumbers.add("11, 12, 13, 14, 25, 26");
    }

    @Test
    void createLottos() {
        List<Lotto> lottos = ManualLottoCreator.createLottos(lottoNumbers);
        assertAll(
                () -> assertThat(lottos).hasSize(2),
                () -> assertThat(lottos.get(0).getLottoNumbers()).hasSize(6)
        );
    }
}
