package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGroupTest {

    static class FakeNumberGenerator implements NumbersGenerator{
        public List<Integer> numbers = List.of(1,2,3,4,5,6);
        @Override
        public List<Integer> generate() {
            return numbers;
        }
    }

    LottoGroup lottoGroup;
    Cash cash = new Cash(2);
    NumbersGenerator generator = new FakeNumberGenerator();

    @BeforeEach
    void setUp() {
        lottoGroup = new LottoGroup(generator);
    }

    @Test
    void generate(){
        lottoGroup.generateTickets(cash);
        LottoGroup otherLottoGroup = new LottoGroup(generator);
        otherLottoGroup.generateTickets(cash);
        assertThat(lottoGroup).isEqualTo(otherLottoGroup);
    }

    @Test
    void to_string() {
        lottoGroup.generateTickets(cash);
        String output = lottoGroup.toString();
        final String expectedResult = "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n";
        assertThat(output).isEqualTo(expectedResult);
    }
}
