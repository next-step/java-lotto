package lotto.domain.strategy;

import lotto.domain.number.LottoNumber;
import lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGenerationStrategyTest {

    private List<Integer> randomNumbers;

    @BeforeEach
    void setUp() {
        randomNumbers = new RandomGenerationStrategy(LottoTicket.LOTTO_NUMBER_SIZE).generate();
    }

    @DisplayName("1 ~ 45 사이의 6개의 숫자를 랜덤으로 생성")
    @Test
    void generate() {
        assertThat(randomNumbers.size()).isEqualTo(LottoTicket.LOTTO_NUMBER_SIZE);
    }

    @DisplayName("랜덤으로 생성한 숫자는 1 ~ 45 사이의 값")
    @Test
    void range() {
        assertThat(randomNumbers.stream()
                .anyMatch(randomNumber -> randomNumber < LottoNumber.MIN_VALUE || randomNumber > LottoNumber.MAX_VALUE))
                .isFalse();
    }

    @DisplayName("랜덤으로 생성한 숫자는 중복되지 않음")
    @Test
    void notDuplicate() {
        assertThat(randomNumbers.size()).isEqualTo(new HashSet<>(randomNumbers).size());
    }
}
