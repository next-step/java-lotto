package step2.view;


import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.Winner;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {
/*
 * Winner class 당첨 클래스
 * 번호 6개여야 함. 문자가 오거나 길이 제한 필요
 * 비교: 로또 번호를 받으면, 매칭(등수) 된 개수 세서 개수 리턴
 * 당첨 금액 계산에 필요
 */
    @Test
    void 번호6개_입력받아서_로또만들기() {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(()-> new Winner(integers))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력_유효성() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Winner(integers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6개 입력하세요");
    }

    @Test
    void 로또_한_장의_당첨_개수_카운팅() {

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Winner winner = new Winner(winningNumbers);

        List<Integer> userNumbers = List.of(1, 2, 3, 4, 7, 9);

        Lotto lotto = new Lotto(userNumbers);
        int count = winner.match(lotto);

        assertThat(count).isEqualTo(4);
    }

    @Test
    void 당첨_로또_저장하기() {

        // 당첨 로또 1개
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Winner winner = new Winner(winningNumbers);

        // 사용자 로또 2개
        List<Integer> userLottoFirst = List.of(1, 2, 3, 9, 10, 12);
        List<Integer> userLottoSecond = List.of(1, 2, 10, 12, 14, 15);

        Lotto lottoFirst = new Lotto(userLottoFirst);
        Lotto lottoSecond = new Lotto(userLottoSecond);

        int userLottoCount = 2;

        Lottos userLottos = new Lottos();

        int firstCount = winner.match(lottoFirst);
        int secondCount = winner.match(lottoSecond);

        assertThat(firstCount).isEqualTo(3);
        assertThat(secondCount).isEqualTo(2);
    }
}
