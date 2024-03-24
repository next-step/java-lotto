package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGroupTest {

    LottoGroup lottoGroup;
    Cash cash = new Cash(2000);
    NumbersGenerator generator = new FakeNumberGenerator();

    @BeforeEach
    void setUp() {
        lottoGroup = new LottoGroup(generator);
    }

    @Test
    @DisplayName("1 ~ 45 사이의 중복되지 않고 오름차순으로 정렬된 6개 정수 생성(1,2,3,4,5,6)")
    void generate() {
        Lotto lotto = new Lotto();
        lotto.generateLottoNumbers(generator.generate(),cash.getAmount());
        lottoGroup = new LottoGroup(generator, lotto);
        assertThat(lottoGroup).isEqualTo(new LottoGroup(generator, lotto));
    }

    @Test
    void to_string() {
        lottoGroup.generateTickets(cash);
        String output = lottoGroup.toString();
        final String expectedResult = "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n";
        assertThat(output).isEqualTo(expectedResult);
    }

    static class FakeNumberGenerator implements NumbersGenerator {
        public List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        @Override
        public List<Integer> generate() {
            return numbers;
        }
    }
}
