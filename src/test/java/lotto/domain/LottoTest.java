package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {
    private static final String DELIMITER = ",";
    private static final int LOTTO_SIZE = 6;

    @DisplayName("랜덤 로또 생성")
    @Test
    void create() {
        Lotto lotto = new Lotto();

        assertThat(lotto).isNotNull();
        assertThat(lotto.getLottoNumbers()).hasSize(LOTTO_SIZE);
    }

    @DisplayName("특정 로또 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    void createByLottoString(String text) {
        String[] lottoStrings = text.trim().split(DELIMITER);
        List<LottoNumber> lottoNumbers = Stream.of(lottoStrings)
                .map(lottoString -> LottoNumber.valueOf(Integer.parseInt(lottoString.trim())))
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(text);

        assertAll(
                () -> assertThat(lotto.getLottoNumbers()).hasSize(lottoNumbers.size()),
                () -> assertThat(lotto.getLottoNumbers()).containsAll(lottoNumbers)
        );
    }

    @DisplayName("로또 번호가 부족하거나 중복될 경우 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 5"})
    void createFailByLottoNumber(String lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumber));
    }

    @DisplayName("로또 번호가 1~45사이가 아닐 시 생성 실패")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 46", "-1, 2, 3, 4, 5, 6"})
    void createFailByInvalidLottoNumber(String lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumber));
    }

    @DisplayName("당첨 확인")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 6:6"}, delimiter = ':')
    void checkWinning(String lottoNumber, String winningNumber, int expected) {
        Lotto buyingLotto = new Lotto(lottoNumber);
        Lotto winningLotto = new Lotto(winningNumber);

        int actual = winningLotto.checkWinning(buyingLotto).getMatchCount();

        assertThat(actual).isEqualTo(expected);
    }
}
