package lotto.domain.stat;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankCountMapTest {

    private Lottos lottos;
    private Lotto winningLotto;

    @BeforeEach
    void init() {
        List<LottoNumber> lottoNumberList = IntStream.range(1, 12)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbers lottoNumbers1 = new LottoNumbers(lottoNumberList.subList(0, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(lottoNumberList.subList(1, 7));
        LottoNumbers lottoNumbers3 = new LottoNumbers(lottoNumberList.subList(2, 8));
        LottoNumbers lottoNumbers4 = new LottoNumbers(lottoNumberList.subList(3, 9));
        LottoNumbers lottoNumbers5 = new LottoNumbers(lottoNumberList.subList(4, 10));
        LottoNumbers lottoNumbers6 = new LottoNumbers(lottoNumberList.subList(5, 11));

        LottoNumbers winningNumbers = new LottoNumbers(lottoNumberList.subList(2, 8));

        Lotto lotto1 = new Lotto(lottoNumbers1);
        Lotto lotto2 = new Lotto(lottoNumbers2);
        Lotto lotto3 = new Lotto(lottoNumbers3);
        Lotto lotto4 = new Lotto(lottoNumbers4);
        Lotto lotto5 = new Lotto(lottoNumbers5);
        Lotto lotto6 = new Lotto(lottoNumbers6);

        lottos = new Lottos(Arrays.asList(
                lotto1,
                lotto2,
                lotto3,
                lotto4,
                lotto5,
                lotto6
        ));

        winningLotto = new Lotto(winningNumbers);
    }

    @Test
    @DisplayName("create 테스트: Lotto별 LottoRank를 잘 계산하여 LottoRankCountMap을 만든다.")
    void create() {
        get();
    }

    @Test
    @DisplayName("get 테스트: 갖고 있는 map에서 해당 key의 대응되는 값을 찾아 리턴한다. 없을경우 0을 리턴한다.")
    void get() {
        LottoRankCountMap lottoRankCountMap = LottoRankCountMap.create(lottos, winningLotto);

        assertEquals(1, lottoRankCountMap.get(LottoRank.FIRST));
        assertEquals(2, lottoRankCountMap.get(LottoRank.SECOND));
        assertEquals(2, lottoRankCountMap.get(LottoRank.THIRD));
        assertEquals(1, lottoRankCountMap.get(LottoRank.FOURTH));
        assertEquals(0, lottoRankCountMap.get(LottoRank.NONE));
    }

}
