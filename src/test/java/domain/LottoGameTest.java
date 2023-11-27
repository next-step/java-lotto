package domain;

import generator.Lotto45NumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LottoGameTest {

    @Test
    @DisplayName("시도한 수만큼 로또를 얻는다.")
    void tryNumber_getLotto() {
        LottoGame lottoGame = LottoGame.create(6, new Lotto45NumbersGenerator(), new ArrayList<>());
        Assertions.assertThat(lottoGame.getLottos().size()).isEqualTo(6);
    }

}