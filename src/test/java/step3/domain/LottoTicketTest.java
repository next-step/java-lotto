package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.common.ErrorCode;
import step3.common.WinningType;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    private final List<LottoNumber> defaultLottoNumbers = Arrays.asList(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
            new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
    );


    @Test
    @DisplayName("로또 티켓 길이 테스트")
    void lottoTicket_shouldBeSix() {
        // success
        assertThat(new LottoTicket(defaultLottoNumbers)).isInstanceOf(LottoTicket.class);

        // failed
        List<LottoNumber> failLottoNumbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3)
        );

        assertThatThrownBy(()->new LottoTicket(failLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
    }

    @Test
    @DisplayName("로또 티켓 정렬 테스트")
    void lottoTicket_shouldBeInOrder() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(2), new LottoNumber(1), new LottoNumber(4),
                new LottoNumber(3), new LottoNumber(6), new LottoNumber(5)
        ));

        LottoNumber[] lottoNumbers = lottoTicket.toArray();

        for(int i=0; i<lottoNumbers.length-1; i++) {
            assertThat(lottoNumbers[i].compareTo(lottoNumbers[i+1]) < 0).isTrue();
        }
    }

    @Test
    @DisplayName("로또 티켓 중복 테스트")
    void lottoTicket_throwDuplicatedLottoNumber() {
        assertThatThrownBy(()->new LottoTicket(Arrays.asList(
                new LottoNumber(1), new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5)
        ))).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.DUPLICATED_LOTTO_NUMBER.getErrorMessage());


    }

//    @Test
//    @DisplayName("로또 티켓 winningType 테스트")
//    void checkWinningType() {
//        WinningType winningType;
//
//        List<LottoNumber> winningLottoNumbers = Arrays.asList(
//                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
//                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
//        );
//
//        // 6개 모두 일치 시에는 1등
//        LottoTicket userFirstLottoTicket = new LottoTicket(defaultLottoNumbers);
//        winningType = userFirstLottoTicket.findWinningType(new int[] {1, 2, 3, 4, 5, 6});
//        assertThat(winningType).isEqualTo(WinningType.FIRST);
//
//        // 4개 일치 시에는 3등
//        List<LottoNumber> userForthLottoNumbers = Arrays.asList(
//                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
//                new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)
//        );
//        LottoTicket userForthLottoTicket = new LottoTicket(userForthLottoNumbers);
//        winningType = userForthLottoTicket.findWinningType(winningLottoNumbers);
//        assertThat(winningType).isEqualTo(WinningType.FORTH);
//
//        // 0개 일치 시에는 7등
//        List<LottoNumber> userSeventhLottoNumbers = Arrays.asList(
//                new LottoNumber(11), new LottoNumber(12), new LottoNumber(13),
//                new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)
//        );
//        LottoTicket userSeventhLottoTicket = new LottoTicket(userSeventhLottoNumbers);
//        winningType = userSeventhLottoTicket.findWinningType(winningLottoNumbers);
//        assertThat(winningType).isEqualTo(WinningType.SEVENTH);
//
//    }
//
//    @Test
//    @DisplayName("로또 티켓 winningType 테스트_잘못된 입력")
//    void checkWinningType_throwInvalidLottoNumbersLength() {
//        LottoTicket lottoTicket = new LottoTicket(defaultLottoNumbers);
//        List<LottoNumber> lottoNumbers = Arrays.asList(
//                new LottoNumber(1), new LottoNumber(2)
//        );
//
//        assertThatThrownBy(()->lottoTicket.findWinningType(lottoNumbers))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_LENGTH.getErrorMessage());
//
//    }

}
