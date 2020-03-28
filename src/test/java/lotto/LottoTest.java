package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    private LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop();
    }

    @DisplayName("구입 금액에 맞게 로또 생성")
    @ParameterizedTest
    @ValueSource(ints = {10000})
    void createLotto(int price) {
        List<Lotto> lottos = lottoShop.buy(price);

        assertThat(lottos).hasSize(Math.floorDiv(price, 1000));
    }

    @DisplayName("특정 로또 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void checkWinning(String text) {
        String[] lottoStrings = text.trim().split(",");
        List<LottoNumber> lottoNumbers = Stream.of(lottoStrings)
                .map(lottoString -> LottoNumber.valueOf(Integer.parseInt(lottoString.trim())))
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(lottoStrings);

        assertAll(
                () -> assertThat(lotto.getLottoNumbers()).hasSize(lottoNumbers.size()),
                () -> assertThat(lotto.getLottoNumbers()).containsAll(lottoNumbers)
        );
    }

    @DisplayName("당첨 확인")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 6:6"}, delimiter = ':')
    void checkWinning(String lottoNumber, String winningNumber, int expected) {
        Lotto buyingLotto = lottoShop.buy(lottoNumber);
        Lotto winningLotto = new Lotto(winningNumber);

        int actual = lottoShop.checkWinning(buyingLotto, winningLotto);

        assertThat(actual).isEqaul(expected);
    }
}
