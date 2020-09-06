package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @DisplayName("로또번호 생성 테스트")
    @Test
    public void 로또번호_생성_테스트() {
        ArrayList<Integer> lottoNums = Stream.iterate(1, n -> n + 1 )
                .limit(6)
                .collect(toCollection(ArrayList::new));

        assertThat(LottoNumbers.create(lottoNums)).isInstanceOf(LottoNumbers.class);
    }
    @DisplayName("로또번호 생성 테스트 isEqaulTo")
    @Test
    public void 로또번호_생성_테스트_isEqaulTo() {
        ArrayList<Integer> lottoNums = Stream.iterate(1, n -> n + 1 )
                .limit(6)
                .collect(toCollection(ArrayList::new));

        LottoNumbers expected = new LottoNumbers();
        assertThat(LottoNumbers.create(lottoNums)).isEqualTo(expected);
    }
}
