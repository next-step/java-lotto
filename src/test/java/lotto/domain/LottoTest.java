package lotto.domain;

import lotto.exception.InvalidLottoLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 생성을 위해서 유효 길이(6)의 리스트가 인자로 전달되어야 한다.")
    @Test
    void 로또_생성_성공() {
        List<Integer> lottoNumbers = Arrays.asList(new Integer[]{1, 3, 4, 7, 22, 59});
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("유효 길이(6)의 리스트가 인자로 전달되지 않는 경우 로또 생성 실패한다.")
    @Test
    void 로또_생성_실패() {
        assertThatThrownBy(() -> {
            List<Integer> lottoNumbers = Arrays.asList(new Integer[]{1, 3, 4, 7, 22, 59, 60});
            Lotto lotto = new Lotto(lottoNumbers);
        }).isInstanceOf(InvalidLottoLengthException.class);
    }
}