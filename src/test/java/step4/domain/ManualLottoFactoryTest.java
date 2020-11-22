package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoFactoryTest {


    @Test
    @DisplayName("로또 넘버들을 입력하면 String로 반환한다.")
    void getLottoNumbersListToString() {
        ManualLottoFactory manualLottoFactory = new ManualLottoFactory(Arrays.asList("1,2,3,4,5,6","2,3,4,5,6,7"));
        assertThat(manualLottoFactory).isEqualTo(new ManualLottoFactory(Arrays.asList("1,2,3,4,5,6","2,3,4,5,6,7")));
    }

    @Test
    @DisplayName("수동로또 리스트를 외부에서 리스트를 더해도 잘 되는지 확인한다.")
    void addExternalLottoNumbers() {
        //given
        ManualLottoFactory manualLottoFactory = new ManualLottoFactory(Arrays.asList("1,2,3,4,5,6","2,3,4,5,6,7"));

        //when
        List<Lotto> lottos = new ArrayList<>();
        manualLottoFactory.addList(lottos);

        //then
        assertThat(lottos).containsExactly(new Lotto(Arrays.asList(1,2,3,4,5,6)),new Lotto(Arrays.asList(2,3,4,5,6,7)));
    }
}