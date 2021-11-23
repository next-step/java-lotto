package lotto.model;

import lotto.application.Constant;
import lotto.factory.LottoFactory;
import lotto.factory.LottoNumberFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    Lotto lotto;
    LottoWinner winner;

    @BeforeEach
    void setUp() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < Constant.LOTTO_NUMBERS_SIZE; i++) {
            numbers.add(LottoNumberFactory.manualCreateNumber(7 * i + 3));
        }

        lotto = LottoFactory.manualCreateSingleLotto(LottoNumberFactory.manualCreateNumbers(numbers));
        winner = new LottoWinner("3, 10, 17, 24, 31, 45");
    }

    @Test
    @DisplayName("로또 생성")
    void ticket() {
        Lotto lotto = LottoStore.ticket(14000);
        assertThat(lotto.getLotto()).hasSize(14);
    }

    @Test
    @DisplayName("로또 번호 당첨 확인")
    void match() {
        LottoStore.match(lotto, winner); //[3, 10, 17, 24, 31, 38]
        LottoNumbers lottoNumbers = lotto.getLotto().get(0);
        assertThat(lottoNumbers.getLottoRank()).isEqualTo(LottoRank.SECOND);
    }
}