package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또 생성 테스트 ")
    public void creation_당첨_로또_인스턴스() {

        Lotto lotto1 = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(toList()));

        Lotto lotto2 = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(toList()));

        LottoNumber bonusNumber = LottoNumber.of(7);

        WinningLotto winningLotto = new WinningLotto(lotto1, bonusNumber);

        assertThat(winningLotto.getRank(lotto2)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("문자열 입력으로 당첨 로또 생성 테스트 ")
    public void creation_string_당첨_로또_인스턴스() {

        Lotto lotto1 = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(toList()));

        Lotto lotto2 = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(toList()));

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", 7);

        assertThat(winningLotto.getRank(lotto2)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("보너스 번호를 잘못 입력한 경우")
    public void 로또번호가_6개를_넘는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {

                            WinningLotto winningLotto = new WinningLotto(
                                    new Lotto(IntStream.rangeClosed(1, 6)
                                            .mapToObj(LottoNumber::of)
                                            .collect(toList())
                                    ),
                                    LottoNumber.of(6)
                            );

                        }
                );
    }


    @Test
    @DisplayName("1등 당첨 로또를 소지한 경우 1등 랭크가 잘 나오는지 확인")
    public void 일등_당첨_로또를_소지한_경우_랭크_1등_확인() {

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::of)
                        .collect(toList())
                ),
                LottoNumber.of(7)
        );

        List<LottoRank> rankList1 = winningLotto.getRankList(Arrays.asList(
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::of)
                        .collect(toList())
                ),
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::of)
                        .collect(toList())
                ))
        );


        assertThat(rankList1.contains(LottoRank.FIRST)).isTrue();
    }

}