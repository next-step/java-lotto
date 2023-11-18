package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    WinnerNumbers winnerNumbers;
    LottoNumbers lottoNumbers;
    List<Lotto> lottoList;
    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers(Set.of(
                new PositiveNumber(1),
                new PositiveNumber(2),
                new PositiveNumber(3),
                new PositiveNumber(4),
                new PositiveNumber(5),
                new PositiveNumber(6)));
        winnerNumbers = new WinnerNumbers(lottoNumbers, new BonusBall(new PositiveNumber(7)));
        lottoList = List.of(
                new Lotto(Set.of(1, 3, 4, 6, 9, 11)),
                new Lotto(Set.of(1, 3, 4, 5, 6, 7))
        );
        lottos = new Lottos(lottoList);
    }

    @Test
    @DisplayName("총 구입금액을 올바르게 리턴한다.")
    void test1() throws Exception {
        assertThat(lottos.totalPurchasePrice()).isEqualTo(2000);
    }

    @Test
    @DisplayName("로또 갯수를 리턴한다.")
    void test2() throws Exception {
        assertThat(lottos.lottoCount()).isEqualTo(2);
    }

}