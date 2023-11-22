package autolotto.domain;

import autolotto.strategy.LottoNumberGenerator;
import autolotto.strategy.LottoNumberGeneratorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoGameTest {

    @Test
    @DisplayName("로또 구매 건수에 맞게 생성되는가")
    void getLottoTickets_발매갯수확인() {
        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorImpl());
        List<Lotto> lottoTickets = lottoGame.getLottoTickets(3);
        assertThat(lottoTickets).hasSize(3);
    }

    @Test
    @DisplayName("로또 하나에 숫자 6개 확인")
    void getLottoTickets_로또숫자확인() {
        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorImpl());
        List<Lotto> lottoTickets = lottoGame.getLottoTickets(3);
        for (Lotto lotto : lottoTickets) {
            assertThat(lotto.lottoNumbers()).hasSize(6);
        }
    }

    @Test
    @DisplayName("로또 생성된 숫자 1~45 범위 내 인지 확인")
    void getLottoTickets_로또숫자범위확인() {
        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorImpl());
        List<Lotto> lottoTickets = lottoGame.getLottoTickets(1);
        assertTrue(lottoTickets.stream()
                .flatMap(lotto -> lotto.lottoNumbers().stream())
                .allMatch(n -> n.getNumber() >= 1 && n.getNumber() <= 45));
    }

    @Test
    @DisplayName("로또 생성된 숫자 중복여부 확인")
    void getLottoTickets_로또숫자중복확인() {
        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorImpl());
        List<Lotto> lottoTickets = lottoGame.getLottoTickets(3);
        boolean checkDup = lottoTickets.stream().allMatch(lotto -> {
            Set<LottoNo> uniqueNumber = new HashSet<>(lotto.lottoNumbers());
            return lotto.lottoNumbers().size() == uniqueNumber.size();
        });
        assertTrue(checkDup);

    }

    @Test
    @DisplayName("1~45 범위내 숫자를 기본적으로 생성하는지 확인.")
    void generateNumber_로또번호기본생성확인() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGeneratorImpl();
        assertTrue(lottoNumberGenerator.generateNumbers().stream().allMatch(n -> n >= 1 && n <= 45));
    }
}