package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("미당첨 로또 결과 생성, 0개 매치")
    void create7() {
        // given
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("42, 41, 40, 10, 20, 30");

        // when
        LottoResult lottoResult = LottoResult.findBy(winningLotto, lotto);

        // then
        assertThat(lottoResult).isNotNull()
                .isEqualTo(LottoResult.NONE);
    }

    @Test
    @DisplayName("미당첨 로또 결과 생성, 1개 매치")
    void create6() {
        // given
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("1, 41, 40, 10, 20, 30");

        // when
        LottoResult lottoResult = LottoResult.findBy(winningLotto, lotto);

        // then
        assertThat(lottoResult).isNotNull()
                .isEqualTo(LottoResult.NONE);
    }

    @Test
    @DisplayName("미당첨 로또 결과 생성, 2개 매치")
    void create5() {
        // given
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("1, 2, 40, 10, 20, 30");

        // when
        LottoResult lottoResult = LottoResult.findBy(winningLotto, lotto);

        // then
        assertThat(lottoResult).isNotNull()
                .isEqualTo(LottoResult.NONE);
    }

    @Test
    @DisplayName("4등 로또 결과 생성, 3개 매치")
    void create4() {
        // given
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("1, 2, 3, 10, 20, 30");

        // when
        LottoResult lottoResult = LottoResult.findBy(winningLotto, lotto);

        // then
        assertThat(lottoResult).isNotNull()
                .isEqualTo(LottoResult.FORTH);
    }

    @Test
    @DisplayName("3등 로또 결과 생성, 4개 매치")
    void create3() {
        // given
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("1, 2, 3, 4, 20, 30");

        // when
        LottoResult lottoResult = LottoResult.findBy(winningLotto, lotto);

        // then
        assertThat(lottoResult).isNotNull()
                .isEqualTo(LottoResult.THIRD);
    }

    @Test
    @DisplayName("2등 로또 결과 생성, 5개 매치")
    void create2() {
        // given
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 30");

        // when
        LottoResult lottoResult = LottoResult.findBy(winningLotto, lotto);

        // then
        assertThat(lottoResult).isNotNull()
                .isEqualTo(LottoResult.SECOND);
    }

    @Test
    @DisplayName("1등 로또 결과 생성, 6개 매치")
    void create1() {
        // given
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");

        // when
        LottoResult lottoResult = LottoResult.findBy(winningLotto, lotto);

        // then
        assertThat(lottoResult).isNotNull()
                .isEqualTo(LottoResult.FIRST);
    }

    @Test
    @DisplayName("6개가 당첨되면 1등이 나온다")
    void match() {
        assertThat(6).isEqualTo(LottoResult.FIRST.matchCount());
    }
}