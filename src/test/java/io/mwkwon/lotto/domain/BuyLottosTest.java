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
        BuyLottos buyLottos = BuyLottos.create(lotto);
        assertThat(buyLottos).isEqualTo(BuyLottos.create(lotto));
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
        Lotto lotto = Lotto.create(lottoNumbers);
        List<Lotto> lottos = Arrays.asList(
                Lotto.create(Stream.of("1,2,3,4,5,6".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList())),
                Lotto.create(Stream.of("1,2,3,4,5,7".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList())),
                Lotto.create(Stream.of("1,2,3,4,5,8".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList())),
                Lotto.create(Stream.of("1,2,3,4,7,8".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList())),
                Lotto.create(Stream.of("1,2,3,8,9,10".split(",")).map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber))).collect(Collectors.toList()))
        );
        BuyLottos buyLottos = BuyLottos.create(lottos);
        WinningLotto winningLotto = WinningLotto.create(lotto, LottoNumber.create(7));
        List<Rank> ranks = buyLottos.calcLottoRank(winningLotto);
        assertThat(ranks).isEqualTo(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH));
    }

    @Test
    void 두개의_buyLottos_merge_테스트() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        Lotto lotto = Lotto.create(lottoNumbers);
        BuyLottos buyLottos = BuyLottos.create(Arrays.asList(lotto));
        List<LottoNumber> lottoNumbers2 = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6));
        Lotto lotto2 = Lotto.create(lottoNumbers2);
        BuyLottos otherBuyLottos = BuyLottos.create(Arrays.asList(lotto2));
        BuyLottos actual = buyLottos.merge(otherBuyLottos);
        assertThat(actual.lottos().size()).isEqualTo(2);
    }
}
