package lotto.util;

import calculator.util.MessageConverter;
import lotto.domain.Buy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class MessageConverterTest {

    @Test
    void 변환() {
        Buy buy = MessageConverter.convert(1000, 2000);

        assertThat(buy.getCount()).isEqualTo(2);
    }
}
