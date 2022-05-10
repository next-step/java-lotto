package lotto;

import lotto.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {

    LottoTicket winningTicket;

    @BeforeEach
    void before(){
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        List<LottoNumber> lottoNumbers = Arrays.stream(nums)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        winningTicket = new LottoTicket(lottoNumbers);
    }


    @Test
    @DisplayName("티켓 생성 테스트")
    void 티켓_생성_테스트(){
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    new LottoTicket(lottoNumbers);
                });
    }

    @Test
    @DisplayName("몇개 일치하는지 테스트")
    void 일치_수_테스트(){
        Integer[] nums = {1, 2, 3, 4, 11, 14};
        List<LottoNumber> lottoNumbers = Arrays.stream(nums)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoTicket lottoTicket =  new LottoTicket(lottoNumbers);
        assertThat(lottoTicket.getRank(winningTicket)).isEqualTo(Rank.four);
    }



}
