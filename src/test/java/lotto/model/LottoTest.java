package lotto.model;

import lotto.factory.LottoNumbersFactory;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("수동 로또 발행")
    void manualTicket() {
        LottoNumbers lottoNumbers = LottoNumbersFactory.createByInput("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(Collections.singletonList(lottoNumbers));
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("자동 로또 발행")
    void autoCreateTicket() {
        Lotto lotto = new Lotto(1);
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("수동, 자동 한장씩 발행")
    void mixCreateTicket() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumbersFactory.createByInput("3, 10, 17, 42, 43, 44"));
        lottoNumbers.add(LottoNumbersFactory.createByGenerator(new LottoNumberGenerator()));

        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.getLottoSize()).isEqualTo(2);
    }

    @Test
    @DisplayName("수동, 자동 한장씩 발행. count로 줬을 때")
    void mixCreateTicketWithCount() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumbersFactory.createByGenerator(new LottoNumberGenerator()));

        Lotto lotto = new Lotto(lottoNumbers, 1);
        assertThat(lotto.getLottoSize()).isEqualTo(2);
    }
}