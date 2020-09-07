package AutoLotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoTest {

    @Test
    void canCreateLotto() {
        UserLotto userLotto = new UserLotto();

        assertThat(userLotto.getUserLotto().size()).isEqualTo(6);
        assertThat(userLotto.getUserLotto().get(0).getLottoNumber()).isLessThanOrEqualTo(45);
        assertThat(userLotto.getUserLotto().get(5).getLottoNumber()).isLessThanOrEqualTo(45);
    }

    @Test
    void tempLottoList() {

        List<LottoNumber> lottoNumberList = IntStream.rangeClosed(1,45)
                .mapToObj(number -> new LottoNumber(number)).collect(Collectors.toList());

        assertThat(lottoNumberList).hasSize(45);
        assertThat(lottoNumberList.get(0)).isInstanceOf(LottoNumber.class);
    }
}
