package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또 생성 테스트 ")
    public void creation_당첨_로또_인스턴스() {

        Lotto lotto1 = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(toList()));

        Lotto lotto2 = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(toList()));

        LottoNumber bonusNumber = new LottoNumber(7);

        WinningLotto winningLotto = new WinningLotto(lotto1, bonusNumber);

        assertThat(winningLotto.getRank(lotto2)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("보너스 번호를 잘못 입력한 경우")
    public void 로또번호가_6개를_넘는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {

                    WinningLotto winningLotto = new WinningLotto(
                            new Lotto(IntStream.rangeClosed(1, 6)
                                    .mapToObj(LottoNumber::new)
                                    .collect(toList())
                            ),
                            new LottoNumber(6)
                    );

                }
                );
    }

}