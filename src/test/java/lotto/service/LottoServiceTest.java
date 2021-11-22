package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;
import lotto.vo.LottoNumber;
import lotto.vo.Money;
import lotto.vo.WinningHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WalletTest {

    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = Wallet.create(Money.create(1000), Lottos.create(Arrays.asList(Lotto.create(Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(7)
        )))));
    }

    @DisplayName("로또 당첨을 확인한 뒤 WinningHistory를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,7:8:1:0:0:0:0", "1,2,3,4,5,6:7:0:1:0:0:0"}, delimiter = ':')
    void buyLottoTest(String winningLottoStr, String bonusStr,
                      int firstCount, int secondCount, int thirdCount, int fourthCount, int fifthCount) {
        LottoNumber bonus = LottoNumber.create(bonusStr);

        Lotto winningLotto = Lotto.create(Arrays.stream(winningLottoStr.split(","))
                .map(LottoNumber::create)
                .collect(Collectors.toList()));
        WinningHistory winningHistory = wallet.getWinningHistory(winningLotto, bonus);

        assertThat(winningHistory.getHistory().stream().filter(WinningRank.FIRST_RANK::equals).count())
                .isEqualTo(firstCount);
        assertThat(winningHistory.getHistory().stream().filter(WinningRank.SECOND_RANK::equals).count())
                .isEqualTo(secondCount);
        assertThat(winningHistory.getHistory().stream().filter(WinningRank.THIRD_RANK::equals).count())
                .isEqualTo(thirdCount);
        assertThat(winningHistory.getHistory().stream().filter(WinningRank.FOURTH_RANK::equals).count())
                .isEqualTo(fourthCount);
    }

    @DisplayName("Winning Lotto 안에 bonus가 있으면 illegal exception")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1", "1,2,3,4,5,6:2", "1,2,3,4,5,6:3", "1,2,3,4,5,6:4", "1,2,3,4,5,6:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    void validBonus(String winningLottoStr, String bonusStr) {
        LottoNumber bonus = LottoNumber.create(bonusStr);

        Lotto winningLotto = Lotto.create(Arrays.stream(winningLottoStr.split(","))
                .map(LottoNumber::create)
                .collect(Collectors.toList()));

        lottoService = new LottoService(Money.create(BigDecimal.valueOf(1000)),
                () -> Arrays.asList(
                        LottoNumber.create(1),
                        LottoNumber.create(2),
                        LottoNumber.create(3),
                        LottoNumber.create(4),
                        LottoNumber.create(5),
                        LottoNumber.create(7)
                )
        );

        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.validBonus(winningLotto, bonus));

    }

}
