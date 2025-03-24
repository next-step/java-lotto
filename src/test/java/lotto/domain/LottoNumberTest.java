package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, 0, -1})
    public void lottoNumber는_1부터_45까지만_가능하다(int number) {
        IllegalArgumentException e
            = catchThrowableOfType(() -> new LottoNumber(number), IllegalArgumentException.class);
        assertThat(e).isNotNull();
    }

}
