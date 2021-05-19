package lotto;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class lottoTest {
    private Lotto lotto;
    List<Integer> defaultLottoNumbers;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
        defaultLottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            defaultLottoNumbers.add(i);
        }
    }

    @DisplayName("입력한 금액 음수, 문자, 소수점 등 예외 발생 확인")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "abcd", "0.345"})
    void validateInputPriceExeption(String price) {
        assertThatThrownBy(() -> {
            lotto.validateInputPrice(price);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("정수만 입력해주세요.");
    }

    @DisplayName("입력한 금액 int 반환 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1000", "14000:14000", "7000:7000"}, delimiter = ':')
    void validateInputPrice(String price, int expected) {
        int result = lotto.validateInputPrice(price);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력한 금액만큼 로또 개수 계산되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void calculateInputPrice(int price, int expected) {
        int result = lotto.calculatePrice(price);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력한 금액만큼 로또 개수가 생성되었는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"100000:100", "14000:14", "7000:7"}, delimiter = ':')
    void countLottoTicket(int price, int expected) {
        List<LottoTicket> lottoTickets=  lotto.createLottoRandomNumbers(lotto.calculatePrice(price));
        assertThat(lottoTickets.size()).isEqualTo(expected);
    }

    @DisplayName("로또번호 생성시 중복 번호가 없는지 확인")
    @RepeatedTest(100)
    void duplicateNumbers() {
        Collections.shuffle(defaultLottoNumbers);
        List<Integer> lottoNumbers = lotto.createSixNumbers(defaultLottoNumbers);
        Set<Integer> setLottoNumbers = new HashSet<>(lottoNumbers);
        assertThat(lottoNumbers.size()).isEqualTo(setLottoNumbers.size());
    }
}