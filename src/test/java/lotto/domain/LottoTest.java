package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@DisplayName("로또 클래스")
class LottoTest {
    private List<LottoNumber> lottoNumbers1 = Arrays.asList(
            LottoNumber.of(1), LottoNumber.of(2),
            LottoNumber.of(3), LottoNumber.of(4),
            LottoNumber.of(5), LottoNumber.of(6)
    );
    private List<LottoNumber> lottoNumbers2 = Arrays.asList(
            LottoNumber.of(1), LottoNumber.of(2),
            LottoNumber.of(3), LottoNumber.of(10),
            LottoNumber.of(20), LottoNumber.of(30)
    );
    private List<LottoNumber> duplicatedNumbers = Arrays.asList(
            LottoNumber.of(3), LottoNumber.of(3),
            LottoNumber.of(3), LottoNumber.of(3),
            LottoNumber.of(3), LottoNumber.of(3)
    );
    private List<LottoNumber> unOrderedNumber = Arrays.asList(
            LottoNumber.of(6), LottoNumber.of(5),
            LottoNumber.of(4), LottoNumber.of(3),
            LottoNumber.of(2), LottoNumber.of(1)
    );

    private Lotto lotto1;
    private Lotto lotto2;

    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private LottoNumber duplicatedNumber;

    @BeforeEach
    void setUp() {
        lotto1 = new Lotto(lottoNumbers1);
        lotto2 = new Lotto(lottoNumbers2);
        winningLotto = lotto1;
        bonusNumber = LottoNumber.of(7);
        duplicatedNumber = LottoNumber.of(1);
    }

    @Test
    void lottoAscendingOrder() {
        Lotto actual = new Lotto(unOrderedNumber);

        assertThat(actual).hasToString(lottoNumbers1.toString());
    }

    @Nested
    @DisplayName("로또 생성자는")
    class Describe_lotto {

        @Nested
        @DisplayName("로또 번호가 올바르게 주어지면")
        class Context_with_valid_numbers {
            final List<LottoNumber> numbers = lottoNumbers1;

            @DisplayName("로또를 생성한다")
            @Test
            void it_return_not_null() {
                final Lotto actual = new Lotto(numbers);
                assertThat(actual).isNotNull();
            }
        }

        @Nested
        @DisplayName("로또 번호가 유효하지 않으면")
        class Context_with_invalid_numbers {
            final List<LottoNumber> numbers = new ArrayList<>();

            @DisplayName("예외를 던진다.")
            @Test
            void it_throws_error() {
                assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(() -> new Lotto(numbers));
            }
        }

        @Nested
        @DisplayName("로또 번호가 중복되어 주어지면")
        class Context_with_duplicated_numbers {
            final List<LottoNumber> numbers = duplicatedNumbers;

            @DisplayName("예외를 던진다.")
            @Test
            void it_throws_error() {
                assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(() -> new Lotto(numbers));
            }
        }
    }

    @Test
    void matchLottoNumber() {
        assertThat(lotto1.getPrizeMatch(winningLotto, bonusNumber)).isSameAs(Prize.FIRST);
    }

    @DisplayName("당첨번호와 보너스 번호 중복시 예외를 던진다")
    @Test
    void bonusNumberDuplicated() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lotto1.getPrizeMatch(winningLotto, duplicatedNumber));
    }
}
