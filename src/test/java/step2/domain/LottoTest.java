package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LottoTest {

    List<Integer> lottoNum;
    Lotto lotto;

    @BeforeEach
    public void init() {
        lottoNum = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
        lotto = Lotto.create(lottoNum);
    }

    @Test
    public void create() {
        assertEquals(lotto, Lotto.create(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("리스트를 인자로 받아 로또 생성")
    public void createUsingListArgs() {
        assertEquals(lotto, Lotto.create(lottoNum));
    }

    @Test
    @DisplayName("로또 번호 갯수 체크")
    public void checkLottoNumberCnt() {
        assertThrows(IllegalArgumentException.class, () -> Lotto.create(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("로또 등수 체크")
    public void containLottoNumberCheck() {
        Lotto winningLotto = Lotto.create(1, 3, 4, 5, 6, 7);
        assertEquals(lotto.match(winningLotto), Rank.SECOND);
    }
}
