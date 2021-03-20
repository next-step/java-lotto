package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoWinnersTest {

    private LottoNumbers winnerNumber;
    private LottoNumber bounsNumber;
    private LottoWinners winners;

    public List<LottoNumber> createLottoNumber() {
        return IntStream.range(1, 6)
                .mapToObj(i -> new LottoNumber(i))
                .collect(Collectors.toList());
    }

    @BeforeEach
    public void setUp() {
        winnerNumber = new LottoNumbers(createLottoNumber());
        bounsNumber = new LottoNumber(45);
        winners = new LottoWinners(winnerNumber, bounsNumber);
    }

    @Test
    @DisplayName("당첨 번호 관리 생성 테스트")
    public void createWinnersTest() throws Exception {
        //given
        LottoWinners winners2 = new LottoWinners(winnerNumber, bounsNumber);

        //when

        //then
        assertThat(winners2.equals(winners)).isTrue();
    }
}
