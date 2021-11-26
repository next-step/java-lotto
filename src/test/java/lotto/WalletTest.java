package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(int money, List<Lotto> lottos) {
        // given
        Wallet self = new Wallet(10000, Arrays.asList(new Lotto(4, 5, 6, 7, 8, 9), new Lotto(1, 2, 3, 4, 5, 6)));

        // when
        Wallet other = new Wallet(money, lottos);

        // then
        assertThat(self).isEqualTo(other);
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(10000, Arrays.asList(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(4, 5, 6, 7, 8, 9)))
        );
    }

    @ParameterizedTest
    @MethodSource("buyLottoSource")
    @DisplayName("")
    void buyLotto(int unitPriceValue, int walletMoney, int result) {
        // given
        Money unitPrice = new Money(unitPriceValue);
        Wallet self = new Wallet(walletMoney);

        // when
        self.buyLotto(unitPrice);

        // then
        assertThat(self.getLottos().size()).isEqualTo(result);
    }

    static Stream<Arguments> buyLottoSource() {
        return Stream.of(
                Arguments.of(1000, 10000, 10),
                Arguments.of(1000, 10500, 10),
                Arguments.of(1000, 11000, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("lottoResultSource")
    @DisplayName("Wallet 은 WinLotto 와 협력하여 LottoResult 를 반환할 수 있다.")
    void lottoResult(List<Lotto> lottos) {
        // given
        Wallet self = new Wallet(0, lottos);
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        final LottoResult lottoResult = self.lottoResult(winLotto);

        // then
        assertThat(lottoResult).isEqualTo(self.lottoResult(winLotto));
    }

    static Stream<Arguments> lottoResultSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(4, 5, 6, 7, 8, 9)))
        );
    }
}
