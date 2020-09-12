package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    @DisplayName("현재 로또에 해당 로또번호가 존재하는지 여부 체크")
    public void containLottoNumberCheck() {
        assertEquals(lotto.contains(new LottoNumber(1)), true);
        assertEquals(lotto.contains(new LottoNumber(32)), false);
    }

    @Test
    @DisplayName("로또 번호 오름차순 정렬 여부 체크")
    public void sortLottoNumberCheck() {
        Lotto lotto = Lotto.create(3, 1, 30, 7, 10, 6);
        Lotto sortedlotto = Lotto.create(3, 1, 30, 7, 10, 6);

        assertEquals(lotto.getLottoNumber(1), 1);
        assertEquals(lotto.getLottoNumber(6), 30);
    }
}
