package lottogame.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lottogame.domain.lotto.LottoNumbers;
import lottogame.domain.strategy.RangeLottoNumberPickerStrategy;
import lottogame.domain.user.User;

class TicketSellerTest {
    @ParameterizedTest(name = "사용자가 티켓을 사고 남은 잔돈과 티켓 수를 검증한다, 소유액: {0}, 티켓 수: {1}, 잔액: {2}")
    @MethodSource("provideLottoTicketSource")
    void sellAutomaticTicketTo(int money, List<LottoNumbers> manualLottoNumbers, int change, int manualCount, int automaticCount) {
        User user = new User(new Money(money), manualLottoNumbers.size(), TicketSeller.getTicketPrice());
        TicketSeller.sellTicketTo(user, manualLottoNumbers);

        assertThat(user.getMoney()).isEqualTo(new Money(change));
        assertThat(user.getManualTicketCount()).isEqualTo(manualCount);
        assertThat(user.getAutomaticTicketCount()).isEqualTo(automaticCount);
    }

    private static Stream<Arguments> provideLottoTicketSource() {
        return Stream.of(
            Arguments.of(12005, getRandomLottoNumbers(3), 5, 3, 12 - 3),
            Arguments.of(10000, getRandomLottoNumbers(5), 0, 5, 10 - 5),
            Arguments.of(12, getRandomLottoNumbers(0), 12, 0, 0)
        );
    }

    private static List<LottoNumbers> getRandomLottoNumbers(int count) {
        var strategy = new RangeLottoNumberPickerStrategy();
        return IntStream.range(0, count)
            .mapToObj((idx) -> strategy.getNumbers())
            .collect(toList());
    }
}
