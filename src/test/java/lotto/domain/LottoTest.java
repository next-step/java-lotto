package lotto.domain;

import lotto.domain.stat.LottoRank;
import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("생성자 테스트: LottoNumber Set의 size가 6보다 작으면 LottoGameException 발생")
    void create() {
        Set<LottoNumber> lottoNumbers = IntStream.range(1, 5)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoGameException.class);
    }

    @Test
    @DisplayName("생성자 테스트: LottoNumber List 요소들의 중복을 제거한 뒤의 size가 6보다 작으면 LottoGameException 발생")
    void create2() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 5)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(LottoGameException.class);
    }

    @Test
    @DisplayName("calculateRank 테스트: 일치하는 숫자 갯수에 맞는 LottoRank를 리턴한다.")
    void caculateRank() {
        List<LottoNumber> lottoNumberList = IntStream.range(1, 20)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(lottoNumberList.subList(0, 6));
        Lotto winningLotto1 = new Lotto(lottoNumberList.subList(0, 6));
        Lotto winningLotto2 = new Lotto(lottoNumberList.subList(1, 7));
        Lotto winningLotto3 = new Lotto(lottoNumberList.subList(2, 8));
        Lotto winningLotto4 = new Lotto(lottoNumberList.subList(3, 9));
        Lotto winningLotto5 = new Lotto(lottoNumberList.subList(4, 10));
        Lotto winningLotto6 = new Lotto(lottoNumberList.subList(10, 16));

        assertEquals(LottoRank.FIRST, lotto.calculateRank(winningLotto1));
        assertEquals(LottoRank.SECOND, lotto.calculateRank(winningLotto2));
        assertEquals(LottoRank.THIRD, lotto.calculateRank(winningLotto3));
        assertEquals(LottoRank.FOURTH, lotto.calculateRank(winningLotto4));
        assertEquals(LottoRank.NONE, lotto.calculateRank(winningLotto5));
        assertEquals(LottoRank.NONE, lotto.calculateRank(winningLotto6));
    }

    @Test
    @DisplayName("contains 테스트: 해당 lottoNumber를 갖고있으면 true, 그렇지 않으면 false를 리턴한다.")
    void contains() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        LottoNumber lottoNumber3 = new LottoNumber(3);
        LottoNumber lottoNumber4 = new LottoNumber(4);
        LottoNumber lottoNumber5 = new LottoNumber(5);
        LottoNumber lottoNumber6 = new LottoNumber(6);
        LottoNumber lottoNumber7 = new LottoNumber(7);

        List<LottoNumber> lottoNumberList = Arrays.asList(
                lottoNumber1,
                lottoNumber2,
                lottoNumber3,
                lottoNumber4,
                lottoNumber5,
                lottoNumber6
        );

        Lotto lotto = new Lotto(lottoNumberList);

        assertTrue(lotto.contains(lottoNumber1));
        assertTrue(lotto.contains(lottoNumber2));
        assertTrue(lotto.contains(lottoNumber3));
        assertTrue(lotto.contains(lottoNumber4));
        assertTrue(lotto.contains(lottoNumber5));
        assertTrue(lotto.contains(lottoNumber6));
        assertFalse(lotto.contains(lottoNumber7));
    }

}
