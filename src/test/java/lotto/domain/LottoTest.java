package lotto.domain;

import lotto.domain.stat.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @Test
    @DisplayName("calculateRank 테스트: 일치하는 숫자 갯수에 맞는 LottoRank를 리턴한다.")
    void caculateRank() {
        List<LottoNumber> lottoNumberList = IntStream.range(1, 20)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList.subList(0, 6));

        LottoNumbers winningNumbers1 = new LottoNumbers(lottoNumberList.subList(0, 6));
        LottoNumbers winningNumbers2 = new LottoNumbers(lottoNumberList.subList(1, 7));
        LottoNumbers winningNumbers3 = new LottoNumbers(lottoNumberList.subList(2, 8));
        LottoNumbers winningNumbers4 = new LottoNumbers(lottoNumberList.subList(3, 9));
        LottoNumbers winningNumbers5 = new LottoNumbers(lottoNumberList.subList(4, 10));
        LottoNumbers winningNumbers6 = new LottoNumbers(lottoNumberList.subList(10, 16));

        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winningLotto1 = new Lotto(winningNumbers1);
        Lotto winningLotto2 = new Lotto(winningNumbers2);
        Lotto winningLotto3 = new Lotto(winningNumbers3);
        Lotto winningLotto4 = new Lotto(winningNumbers4);
        Lotto winningLotto5 = new Lotto(winningNumbers5);
        Lotto winningLotto6 = new Lotto(winningNumbers6);

        assertEquals(LottoRank.FIRST, lotto.calculateRank(winningLotto1));
        assertEquals(LottoRank.SECOND, lotto.calculateRank(winningLotto2));
        assertEquals(LottoRank.THIRD, lotto.calculateRank(winningLotto3));
        assertEquals(LottoRank.FOURTH, lotto.calculateRank(winningLotto4));
        assertEquals(LottoRank.NONE, lotto.calculateRank(winningLotto5));
        assertEquals(LottoRank.NONE, lotto.calculateRank(winningLotto6));
    }

}
