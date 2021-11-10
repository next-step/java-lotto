package lotto.domain;

import lotto.vo.LottoNumber;
import lotto.vo.Lottos;
import lotto.vo.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Map;
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

    @DisplayName("로또 당첨을 확인한 뒤 EnumMap을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:4001550000", "2,3,4,5,6,7:2004500000"}, delimiter = ':')
    void buyLottoTest(String winningLottoStr, long winningMoney) {
        Lotto winningLotto = Lotto.create(Arrays.stream(winningLottoStr.split(","))
                .map(LottoNumber::create)
                .collect(Collectors.toList()));
        wallet.checkWinning(winningLotto);

        assertThat(wallet.isEqualWinningMoney(Money.create(winningMoney))).isTrue();

//        assertThat(history.getOrDefault(WinningRank.FIRST_RANK,0L)).isEqualTo(first);
//        assertThat(history.getOrDefault(WinningRank.SECOND_RANK,0L)).isEqualTo(second);
//        assertThat(history.getOrDefault(WinningRank.THIRD_RANK,0L)).isEqualTo(third);
//        assertThat(history.getOrDefault(WinningRank.FOURTH_RANK,0L)).isEqualTo(fourth);
//        System.out.println("history = " + history);
    }
}
