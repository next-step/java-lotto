package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static lotto.util.LottoStringFixtureUtil.convertStringToLottoNumberList;
import static lotto.util.LottoStringFixtureUtil.lottoNumbersSortedByRank;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameTest {
    @Test
    @DisplayName("금액을 주어, 로또를 생성하고 결과를 확인한다")
    public void 금액을_주어_로또를_생성하고_결과를_확인한다() {
        int ticketSize = 10;
        int dummyMoney = 500;
        int moneyInHand = ticketSize * 1000 + dummyMoney;

        PositiveNumber money = new PositiveNumber(moneyInHand);
        Game game = Game.createByMoneyAndGenerator(money, createLottoGenerator());
        LottoWon lottoWon = new LottoWon(convertStringToLottoNumberList("1,2,3,4,5,6"), LottoNumber.of(7));

        LottoRanks match = game.match(lottoWon);

        assertThat(match.countOf(LottoRank.FIRST))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.SECOND))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.THIRD))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.FOURTH))
                .isEqualTo(2);
        assertThat(match.countOf(LottoRank.FIFTH))
                .isEqualTo(2);
        assertThat(match.countOf(LottoRank.MISS))
                .isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1999})
    @DisplayName("금액보다 많은 수동로또번호가 입력되면 IllegalArgumentException이 발생한다")
    public void 금액보다_많은_수동로또번호가_입력되면_IllegalArgumentException이_발생한다(int money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Game.createWithManualTicketByMoney(
                        new LottoTickets(
                                Arrays.asList(
                                        new LottoTicket(convertStringToLottoNumberList("1,2,3,4,5,6")),
                                        new LottoTicket(convertStringToLottoNumberList("1,2,3,4,5,6"))
                                )
                        ),
                        new PositiveNumber(money)));
    }

    @ParameterizedTest
    @ValueSource(ints = {2000, 2001, 3000})
    @DisplayName("금액보다 적은 수동로또번호가 입력되면 문제없다")
    public void 금액보다_많은_수동로또번호가_입력되면_문제없다(int money) {
        assertDoesNotThrow(() -> Game.createWithManualTicketByMoney(
                new LottoTickets(
                        Arrays.asList(
                                new LottoTicket(convertStringToLottoNumberList("1,2,3,4,5,6")),
                                new LottoTicket(convertStringToLottoNumberList("1,2,3,4,5,6"))
                        )
                ),
                new PositiveNumber(money)));
    }

    @Test
    @DisplayName("금액이 입력되면 수동의 개수를 뺀 만큼의 로또가 자동 생성이 되고, 수동으로 입력한 값이 전체안에 포함이 되어야 한다.")
    public void 금액이_입력되면_수동의_개수를_뺀_만큼의_로또가_자동_생성이_되고_수동으로_입력한_값이_전체안에_포함이_되어야_한다() {
        int totalTicket = 50;
        int priceOfTicket = 1000;

        List<LottoTicket> manualLottoTickets = Arrays.asList(
                new LottoTicket(convertStringToLottoNumberList("1,2,3,4,5,6")),
                new LottoTicket(convertStringToLottoNumberList("2,3,4,5,6,7")),
                new LottoTicket(convertStringToLottoNumberList("3,4,5,6,7,8")),
                new LottoTicket(convertStringToLottoNumberList("4,5,6,7,8,9")),
                new LottoTicket(convertStringToLottoNumberList("5,6,7,8,9,10")),
                new LottoTicket(convertStringToLottoNumberList("6,7,8,9,10,11")));

        Game withManualTicketByMoney = Game.createWithManualTicketByMoney(
                new LottoTickets(manualLottoTickets),
                new PositiveNumber(totalTicket * priceOfTicket));

        assertThat(withManualTicketByMoney.sizeOfManualLottoTickets())
                .isEqualTo(manualLottoTickets.size());
        assertThat(withManualTicketByMoney.sizeOfAutoLottoTickets())
                .isEqualTo(totalTicket - manualLottoTickets.size());
        assertThat(withManualTicketByMoney.getAllLottoTickets().size())
                .isEqualTo(totalTicket);

        assertThat(withManualTicketByMoney.getAllLottoTickets()
                .getTickets())
                .containsAll(manualLottoTickets);


    }

    public LottoNumberGenerator createLottoGenerator() {
        return new LottoNumberGenerator() {
            private int index = 0;

            @Override
            public Set<LottoNumber> generate() {
                String[] lottoNumbersSortedByRank = lottoNumbersSortedByRank();
                return convertStringToLottoNumberList(lottoNumbersSortedByRank[++index]);
            }
        };
    }
}
