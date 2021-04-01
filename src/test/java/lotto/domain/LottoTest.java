package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static lotto.domain.LottoNumber.LOWER_LOTTONUMBER_BOUND;
import static lotto.domain.LottoNumbers.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;
    private LottoNumbers lottoNumbers;
    private Set<LottoNumber> numbers = new LinkedHashSet<>();

    @BeforeEach
    void setUp() { //given
        for (int i = LOWER_LOTTONUMBER_BOUND; i <= LOTTO_SIZE; i++) {
            numbers.add(new LottoNumber(i));
        }
        lottoNumbers = new LottoNumbers(numbers);
        lotto = new Lotto(lottoNumbers);
    }

    @Test
    void createTest() {
        //then
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void containsTest() {
        //given
        Set<LottoNumber> testNumbers = new LinkedHashSet<>();
        Set<LottoNumber> zeroMatches = new LinkedHashSet<>();
        for (int i = LOWER_LOTTONUMBER_BOUND + 1; i <= LOTTO_SIZE + 1; i++) {
            testNumbers.add(new LottoNumber(i));
            zeroMatches.add(new LottoNumber(LOTTO_SIZE + i + 10));
        }


        //when
        int allCorrect = lotto.contains(lottoNumbers);
        int fiveCorrect = lotto.contains(new LottoNumbers(testNumbers));
        int zeroCorrect = lotto.contains(new LottoNumbers(zeroMatches));

        //then
        assertThat(allCorrect).isEqualTo(LOTTO_SIZE);
        assertThat(fiveCorrect).isEqualTo(5);
        assertThat(zeroCorrect).isEqualTo(0);
    }

    @Test
    void containBounsTest() {
        //given
        LottoNumber cotainBonus = new LottoNumber(LOTTO_SIZE);
        LottoNumber notInBonus = new LottoNumber(LOTTO_SIZE + 1);

        //when, then
        assertThat(lotto.containsBouns(cotainBonus)).isTrue();
        assertThat(lotto.containsBouns(notInBonus)).isFalse();
    }

    @Test
    void printTest() {
        System.out.println(lotto.numbers());
    }
}
