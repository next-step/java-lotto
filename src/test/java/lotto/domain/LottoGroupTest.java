package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoGroupTest {
    @Test
    void LottoGroup_로또그룹_생성한다() {
        LottoGroup lottoGroup = new LottoGroup(List.of(
                Lotto.create(new int[]{1, 2, 3, 4, 5, 6}),
                Lotto.create(new int[]{7, 8, 9, 10, 11, 12}))
        );
        assertThat(lottoGroup).isEqualTo(new LottoGroup(
                List.of(
                        new Lotto(List.of(
                                LottoNumber.create(1), LottoNumber.create(2), LottoNumber.create(3), LottoNumber.create(4), LottoNumber.create(5), LottoNumber.create(6)
                        )),
                        new Lotto(List.of(
                                LottoNumber.create(7), LottoNumber.create(8), LottoNumber.create(9), LottoNumber.create(10), LottoNumber.create(11), LottoNumber.create(12)
                        ))
                )
        )).isEqualTo(lottoGroup);
    }

    @Test
    void LottoGroup_로또그룹_생성한다_전략패턴이용() {
        LottoGroup lottoGroup = new LottoGroup(List.of(
                Lotto.create(new int[]{1, 2, 3, 4, 5, 6}),
                Lotto.create(new int[]{1, 2, 3, 4, 5, 6}))
        );
        assertThat(lottoGroup).isEqualTo(LottoGroup.create(2, () -> List.of(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6))));
    }

    @Test
    void LottoGroup_로또갯수가_음수인_경우() {
        assertThatThrownBy(() -> LottoGroup.createLottos(-1, () -> List.of(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6)))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getLottoGroupResult_로또그룹_결과를_반환한다() {
        LottoGroup lottoGroup = new LottoGroup(List.of(
                Lotto.create(new int[]{1, 2, 3, 4, 5, 6}),
                Lotto.create(new int[]{6, 8, 9, 10, 1, 12}),
                Lotto.create(new int[]{6, 8, 9, 10, 4, 12}),
                Lotto.create(new int[]{6, 8, 9, 10, 5, 1}),
                Lotto.create(new int[]{4, 5, 6, 16, 17, 18}),
                Lotto.create(new int[]{19, 20, 21, 22, 23, 24}),
                Lotto.create(new int[]{25, 26, 27, 28, 29, 30}),
                Lotto.create(new int[]{31, 32, 33, 34, 35, 36}),
                Lotto.create(new int[]{37, 38, 39, 40, 41, 42}))
        );
        assertThat(lottoGroup.getLottoGroupResult(new WinningLotto(Lotto.create(new int[]{4, 5, 6, 8, 9, 10}), LottoNumber.create(1)))).isEqualTo(new LottoGroupResult(Map.of(
                LottoRank.MISS, 4,
                LottoRank.FIFTH, 2,
                LottoRank.FOURTH, 1,
                LottoRank.THIRD, 1,
                LottoRank.SECOND, 1
        )));
    }

    @ParameterizedTest
    @NullSource
    void LottoGroup_로또리스트가_null_인_경우(List<Lotto> lottos) {
        assertThatThrownBy(() -> new LottoGroup(lottos)).isInstanceOf(IllegalArgumentException.class);
    }
}