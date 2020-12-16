package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoUserRequestTest {

    @DisplayName("구매자 요청 객체 생성 - 모두 자동 생성 case")
    @Test
    void create() {
        //given
        int money = 14_000;
        LottoUserRequest lottoUserRequest = new LottoUserRequest(money);

        //when, then
        assertThat(lottoUserRequest.hasManualIssueTarget()).isFalse();
    }

    @DisplayName("구매자 요청 객체 생성 - 일부 수동 생성 case")
    @Test
    void create_manualCount() {
        //given
        int money = 14_000;
        String[] manualTicketNumbers = {"8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38",
              "7, 11, 16, 35, 36, 44"};
        LottoUserRequest lottoUserRequest = new LottoUserRequest(money, manualTicketNumbers);

        //when, then
        assertThat(lottoUserRequest.hasManualIssueTarget()).isTrue();
        assertThat(lottoUserRequest.hasAutoIssueTarget()).isTrue();
    }
}
