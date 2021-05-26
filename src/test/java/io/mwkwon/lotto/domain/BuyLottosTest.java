package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyLottosTest {

    @Test
    void 구매_로또_일급_컬렉션_객체_정상_생성_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        List<Lotto> lotto = Arrays.asList(Lotto.create(lottoNumbers));
        BuyLottos buyLottos = new BuyLottos(lotto);
        assertThat(buyLottos).isEqualTo(new BuyLottos(lotto));
    }

    @Test
    void 구매한_로또_당첨_결과_계산_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        Lotto winningLotto = Lotto.create(lottoNumbers);
        List<Lotto> lottos = Arrays.asList(
                Lotto.create(Stream.of("1,2,3,4,5,6".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList())),
                Lotto.create(Stream.of("1,2,3,4,5,7".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList())),
                Lotto.create(Stream.of("1,2,3,4,5,8".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList())),
                Lotto.create(Stream.of("1,2,3,4,7,8".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList())),
                Lotto.create(Stream.of("1,2,3,8,9,10".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList()))
        );
        BuyLottos buyLottos = new BuyLottos(lottos);
        List<Rank> ranks = buyLottos.calcLottoRank(winningLotto, LottoNumber.create(7));
        assertThat(ranks).isEqualTo(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH));
    }
}
