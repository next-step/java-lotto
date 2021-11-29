package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

    @ValueSource(strings = {"-1,2,4,7,11,6", "46,2,4,7,11,6", "0,2,4,7,11,6", "77,2,4,7,11,6",
        "1000,2,4,7,11,6"})
    @ParameterizedTest(name = "[{argumentsWithNames}] LottoTicket 의 생성 범위는 1~45이어야 한다.")
    void lottoTicketValidateTest(String input) {
        List<Integer> inputInvalidLottoNumbers = Arrays.stream(input.split(","))
            .map(Integer::new)
            .collect(Collectors.toList());

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoTicket(inputInvalidLottoNumbers));
    }

    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4", "1,2,3"})
    @ParameterizedTest(name = "[{argumentsWithNames}] LottoTicket 의 갯수는 6개여야 한다.")
    void lottoTicketSizeValidateTest(String input) {

        List<Integer> inputInvalidLottoNumbers = Arrays.stream(input.split(","))
            .map(Integer::new)
            .collect(Collectors.toList());

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoTicket(inputInvalidLottoNumbers));
    }

}