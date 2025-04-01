package lotto.domain.model.lotto;

import lotto.domain.strategy.LottoNumberGeneratorStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketFactoryTest {

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    void createLottoTickets() {
        LottoNumberGeneratorStrategy strategy = new FixedLottoNumberGeneratorStrategy();
        LottoTicketFactory factory = new LottoTicketFactory(strategy);
        int count = 5;

        List<LottoTicket> tickets = factory.create(count);

        assertThat(tickets).hasSize(count);
        for (LottoTicket ticket : tickets) {
            assertThat(ticket.getNumbers()).hasSize(6);
            assertThat(ticket.getNumbers()).isEqualTo(strategy.generate());
        }
    }

    @DisplayName("당첨 로또 티켓 생성 테스트")
    @Test
    void createWinningLottoTicket() {
        LottoTicketFactory factory = new LottoTicketFactory();
        Set<LottoNumber> winningNumbers = createLottoNumbers(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(7);

        WinningLottoTicket winningTicket = factory.createWinning(winningNumbers, bonusNumber);

        assertThat(winningTicket.getNumbers()).containsExactlyInAnyOrderElementsOf(winningNumbers);
        assertThat(winningTicket.getBonusNumber()).isEqualTo(bonusNumber);
    }

    private Set<LottoNumber> createLottoNumbers(final int... numbers) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    private static class FixedLottoNumberGeneratorStrategy implements LottoNumberGeneratorStrategy {
        @Override
        public Set<LottoNumber> generate() {
            return Set.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            );
        }
    }
} 
