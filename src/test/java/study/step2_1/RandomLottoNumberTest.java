package study.step2_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import study.step2.domain.RandomLottoNumberGenerator;
import study.step2_1.domain.RandomLottoNumber;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoNumberTest {

    @RepeatedTest(20)
    @DisplayName("로또 티켓은 6개의 번호로 되어 있는지 테스트")
    public void lottoNumberCountTest(){
        assertThat(new RandomLottoNumber().getLottoNumbers()).hasSize(6);
    }

    @RepeatedTest(20)
    @DisplayName("랜덤으로 이루어진 로또 번호 각각은 중복되지 않는지 테스트")
    public void lottoTicketNumberDuplicationTest(){
        List<Integer> deduplicationNumbers =  new RandomLottoNumber().getLottoNumbers()
                                                                     .stream()
                                                                     .distinct()
                                                                     .collect(Collectors.toList());
        assertThat(deduplicationNumbers).hasSize(6);
    }
}
