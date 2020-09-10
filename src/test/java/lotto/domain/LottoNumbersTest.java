package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @DisplayName("로또번호 1등 찾기")
    @Test
    public void 로또번호_1등찾기() {
        ArrayList<Integer> lottoNums = Stream.iterate(1, n -> n + 1 )
                .limit(6)
                .collect(toCollection(ArrayList::new));
        assertThat(LottoNumbers.create(lottoNums).getLottoRank(lottoNums)).isEqualTo(Rank.FirstPlace);
    }

    @DisplayName("로또번호 2등 찾기")
    @Test
    public void 로또번호_2등찾기() {
        ArrayList<Integer> lottoNums = Stream.iterate(1, n -> n + 1 )
                .limit(6)
                .collect(toCollection(ArrayList::new));

        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertThat(LottoNumbers.create(lottoNums).getLottoRank(expected)).isEqualTo(Rank.SecondPlace);
    }

    @DisplayName("로또번호 3등 찾기")
    @Test
    public void 로또번호_3등찾기() {
        ArrayList<Integer> lottoNums = Stream.iterate(1, n -> n + 1 )
                .limit(6)
                .collect(toCollection(ArrayList::new));

        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 7, 8));

        assertThat(LottoNumbers.create(lottoNums).getLottoRank(expected)).isEqualTo(Rank.ThirdPlace);
    }

    @DisplayName("로또번호 4등 찾기")
    @Test
    public void 로또번호_4등찾기() {
        ArrayList<Integer> lottoNums = Stream.iterate(1, n -> n + 1 )
                .limit(6)
                .collect(toCollection(ArrayList::new));

        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 9, 7, 8));

        assertThat(LottoNumbers.create(lottoNums).getLottoRank(expected)).isEqualTo(Rank.FourthPlace);
    }



}
