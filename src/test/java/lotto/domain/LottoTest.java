package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(10000);
    }

//    @Test
//    void 로또숫자들은_1부터45까지의_중복되지_않은_6개의_수들이다() {
//        List<LottoNumber> lottoNumbers = lotto.generateRandoms();
//        long given = lottoNumbers.stream().distinct().count();
//        assertThat(given).isEqualTo(LOTTO_SIZE);
//    }

    @ValueSource(ints = {2, 3, 4})
    @ParameterizedTest
    void 구입금액에_맞는_로또를_발급한다(int number) {
        List<LottoTicket> generatedTickets = lotto.generateLottoTickets(number);
        int given = generatedTickets.size();
        assertThat(given).isEqualTo(number);
    }

    @Test
    void 로또넘버중_당첨넘버와_일치하는_수에_따라_당첨결과가_나온다_1등() {
        final LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6),
            40);

        LottoRank given = winningNumbers.getRankForLottoTicket(lottoTicket);
        assertThat(given).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 로또넘버중_당첨넘버와_일치하는_수에_따라_당첨결과가_나온다_2등() {
        final LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7),
            6);

        LottoRank given = winningNumbers.getRankForLottoTicket(lottoTicket);
        assertThat(given).isEqualTo(LottoRank.SECOND);
    }
}
