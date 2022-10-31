package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {

    String numberString;

    @BeforeEach
    void setUp() {
        numberString = "1, 2, 3, 4, 5, 6";
    }

    @Test
    @DisplayName("로또 티켓 수동으로 1장 생성")
    void createManually() {
        Lotto lotto = new Lotto(numberString);
        assertThat(lotto).isEqualTo(new Lotto(numberString));
    }

    @Test
    @DisplayName("로또 티켓 자동으로 1장 생성")
    void createAutomatically() {
        Lotto lotto = new Lotto();
        assertThat(lotto).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("번호 6개가 아닌 다른 개수로 로또 티켓을 생성하려는 경우")
    void notSixNumbers() {
        numberString = "1, 2, 3, 4, 5, 6, 7";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numberString));
    }

    @Test
    @DisplayName("매칭되는 숫자 개수 반환")
    void matchingCount() {
        String winningNumbers = "4, 5, 6, 7, 8, 9";
        Lotto lotto = new Lotto(numberString);
        Lotto winningLotto = new Lotto(winningNumbers);

        assertThat(lotto.match(winningLotto)).isEqualTo(3);
    }

    @Test
    @DisplayName("보너스볼 번호와 일치되는 번호가 있는지 확인")
    void checkMatchingNumberWithBonusBall() {
        Lotto lotto = new Lotto(numberString);
        LottoNumber bonusBall = LottoNumber.of(3);
        assertTrue(lotto.isMatch(bonusBall));
    }
}
