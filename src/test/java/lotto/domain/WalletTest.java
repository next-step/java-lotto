package lotto.domain;

import lotto.vo.LottoNumber;
import lotto.vo.Lottos;
import lotto.vo.Money;
import lotto.vo.WinningHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class WalletTest {
    private Wallet wallet;

    @BeforeEach
    void setUp() {
        Lottos lottos = Lottos.create(Arrays.asList(
                Lotto.create(Arrays.asList(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(6)
                )),
                Lotto.create(Arrays.asList(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(6)
                )),
                Lotto.create(Arrays.asList(
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(6),
                        LottoNumber.create(7)
                )),
                Lotto.create(Arrays.asList(
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(6),
                        LottoNumber.create(7),
                        LottoNumber.create(8)
                ))
        ));
        Money money = Money.create(3000);
        wallet = Wallet.create(lottos, money);
    }

    @DisplayName("로또 당첨을 확인한 뒤 WinningHistory를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:4001550000:2:1:1:0", "2,3,4,5,6,7:2004500000:1:3:0:0"}, delimiter = ':')
    void buyLottoTest(String winningLottoStr, long winningMoney,
                      int firstCount, int secondCount, int thirdCount, int fourthCount) {
        Lotto winningLotto = Lotto.create(Arrays.stream(winningLottoStr.split(","))
                .map(LottoNumber::create)
                .collect(Collectors.toList()));
        WinningHistory winningHistory = wallet.checkWinning(winningLotto);

        assertThat(winningHistory.getWinningMoney()).isEqualTo(Money.create(winningMoney));
        assertThat(winningHistory.getHistory().stream().filter(WinningRank.FIRST_RANK::equals).count())
                .isEqualTo(firstCount);
        assertThat(winningHistory.getHistory().stream().filter(WinningRank.SECOND_RANK::equals).count())
                .isEqualTo(secondCount);
        assertThat(winningHistory.getHistory().stream().filter(WinningRank.THIRD_RANK::equals).count())
                .isEqualTo(thirdCount);
        assertThat(winningHistory.getHistory().stream().filter(WinningRank.FOURTH_RANK::equals).count())
                .isEqualTo(fourthCount);
    }
}
