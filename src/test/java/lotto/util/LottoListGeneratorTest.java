package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoListGeneratorTest {
    private List<Set<Integer>> manualLottoList;
    private Set<Integer> manualLotto = new HashSet<>();

    @BeforeEach
    void setUp() {
        manualLottoList = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(number -> manualLotto.add(number));
        manualLottoList.add(manualLotto);
    }

    @Test
    @DisplayName("수동 로또가 잘 생성되었는지 확인한다.")
    void creatLottos() {
        int ticketNumber = 3;
        List<Lotto> lottos = LottoGenerator.createLottos(manualLottoList, ticketNumber);
        Lotto lotto = new Lotto(manualLotto.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toSet()));
        assertEquals(lottos.get(0).countContains(lotto), 6);
        assertEquals(lottos.size(), ticketNumber);
    }

    @Test
    @DisplayName("수동 로또의 개수가 총 개수보다 많을 때 IllegalArgumentException이 발생한다.")
    void manualLottoSizeOver() {
        int ticketNumber = 1;
        manualLottoList.add(manualLotto);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGenerator.createLottos(manualLottoList, ticketNumber))
                .withMessage("수동 로또의 갯수가 총 개수보다 많습니다. 수동 로또 개수 : " + manualLottoList.size());
    }
}