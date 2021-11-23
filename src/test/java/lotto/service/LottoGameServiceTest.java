package lotto.service;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameServiceTest {
    @Test
    @DisplayName("LottoGameService 생성자 테스트")
    public void constructor() {
        assertThat(new LottoGameService()).isEqualTo(new LottoGameService());
    }

    @Test
    @DisplayName("1~45의 기본 리스트를 생성한다.")
    public void makeDefaultLottoNumbers() {
        LottoGameService service = new LottoGameService();
//        service.makeDefaultLottoNumbers();
//        assertThat(service.getDefaultLottoNumbers())
//                .isEqualTo(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())));
    }

}
