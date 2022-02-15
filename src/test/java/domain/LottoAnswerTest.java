package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoAnswerTest {

    @Test
    @DisplayName("정답 개수가 6개 초과일시 Exception 테스트")
    void checkInputNumberCount() {
        List<LottoNumber> answer = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoAnswer(answer, new LottoNumber(10)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정답 범위가 1~45 벗어나면 Exception 테스트")
    void checkNumberRange() {
        assertThatThrownBy(() -> new LottoAnswer(
                Stream.of(1, 2, 3, 4, 5, 99)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()), new LottoNumber(10)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 범위가 1~45 벗어나면 Exception 테스트")
    void checkBonusNumberRange() {
        assertThatThrownBy(() -> new LottoAnswer(
                Stream.of(1, 2, 3, 4, 5, 6)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()), new LottoNumber(46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또들을 총 몇 개 맞췄는지 테스트")
    void checkLottoAnswerMatch() {
        //given
        Lotto lotto1 = Lotto.create(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        Lotto lotto2 = Lotto.create(Stream.of(5, 6, 7, 8, 9, 10)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));


        LottoAnswer lottoAnswer = new LottoAnswer(
                Stream.of(1, 2, 3, 7, 8, 9)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()), new LottoNumber(11));

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLotto(lotto1);
        lottoTickets.addLotto(lotto2);

        //when
        LottoResult lottoResult = lottoAnswer.checkLottoAnswer(lottoTickets.getLottos());

        //then
        assertThat(lottoResult.getRankCount(Rank.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("보너스까지 맞췄는지 테스트")
    void checkLottoBonusMatch() {
        //given
        Lotto lotto1 = Lotto.create(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        Lotto lotto2 = Lotto.create(Stream.of(5, 6, 7, 8, 9, 10)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        LottoAnswer lottoAnswer = new LottoAnswer(
                Stream.of(1, 2, 3, 4, 5, 7)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()), new LottoNumber(6));

        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLotto(lotto1);
        lottoTickets.addLotto(lotto2);

        //when
        LottoResult lottoResult = lottoAnswer.checkLottoAnswer(lottoTickets.getLottos());

        //then
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
    }


    @Test
    @DisplayName("로또들을 하나도 못 맞췄을 때 테스트")
    void checkLottoAnswerNonMatch() {
        //given
        Lotto lotto = Lotto.create(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        LottoAnswer lottoAnswer = new LottoAnswer(
                Stream.of(7, 8, 9, 10, 11, 12)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()), new LottoNumber(5));
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLotto(lotto);

        //when
        LottoResult lottoResult = lottoAnswer.checkLottoAnswer(lottoTickets.getLottos());

        //then
        assertThat(lottoResult.getRankCount(Rank.FAIL)).isEqualTo(1);
    }
}