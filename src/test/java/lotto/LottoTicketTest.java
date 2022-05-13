package lotto;

import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.InvalidLottoTicketSizeException;
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
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
        winningTicket = new LottoTicket(lottoNumbers);
    }


    @Test
    @DisplayName("로또번호가 6개가 아니라면 예외를 던진다")
    void 티켓_생성_테스트(){
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        assertThatExceptionOfType(InvalidLottoTicketSizeException.class)
                .isThrownBy(()->{
                    new LottoTicket(lottoNumbers);
                });
    }

    @Test
    @DisplayName("중복되는 숫자가 있다면 예외를 던진다")
    void 숫자_중복_예외_테스트(){
        Integer[] ints = {1, 2, 3, 4, 5, 5};
        assertThatExceptionOfType(DuplicatedLottoNumberException.class)
                .isThrownBy(()->{
                    new LottoTicket(ints);
                });
    }

    @Test
    @DisplayName("몇개 일치하는지 테스트")
    void 일치_수_테스트(){
        // given
        Integer[] nums = {1, 2, 3, 4, 11, 14};
        LottoTicket lottoTicket =  new LottoTicket(nums);

        // when
        Rank rankRes = lottoTicket.getRank(winningTicket);

        // then
        assertThat(rankRes).isEqualTo(Rank.four);
    }
}
