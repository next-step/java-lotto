package lotto.io.domain.code;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ViewCodeTest {

	@DisplayName("4-2-1-3-1.`is~()` : 등가성 비교")
	@Test
	@Order(1)
	void isEqualMethods() {
		//given

		//when

		//then
		//isTicketBoxView()
		assertThat(ViewCode.TICKET_BOX.isTicketBoxView()).isEqualTo(true);
		assertThat(ViewCode.GAME_WINNING_CONDITION.isTicketBoxView()).isEqualTo(false);
		assertThat(ViewCode.WINNING_STATICS.isTicketBoxView()).isEqualTo(false);
		assertThat(ViewCode.SHUTDOWN_APPLICATION.isTicketBoxView()).isEqualTo(false);
		//isGameWinningConditionView()
		assertThat(ViewCode.TICKET_BOX.isGameWinningConditionView()).isEqualTo(false);
		assertThat(ViewCode.GAME_WINNING_CONDITION.isGameWinningConditionView()).isEqualTo(true);
		assertThat(ViewCode.WINNING_STATICS.isGameWinningConditionView()).isEqualTo(false);
		assertThat(ViewCode.SHUTDOWN_APPLICATION.isGameWinningConditionView()).isEqualTo(false);
		//isWinningStaticsView()
		assertThat(ViewCode.TICKET_BOX.isWinningStaticsView()).isEqualTo(false);
		assertThat(ViewCode.GAME_WINNING_CONDITION.isWinningStaticsView()).isEqualTo(false);
		assertThat(ViewCode.WINNING_STATICS.isWinningStaticsView()).isEqualTo(true);
		assertThat(ViewCode.SHUTDOWN_APPLICATION.isWinningStaticsView()).isEqualTo(false);
		//isShutdownApplication()
		assertThat(ViewCode.TICKET_BOX.isShutdownApplication()).isEqualTo(false);
		assertThat(ViewCode.GAME_WINNING_CONDITION.isShutdownApplication()).isEqualTo(false);
		assertThat(ViewCode.WINNING_STATICS.isShutdownApplication()).isEqualTo(false);
		assertThat(ViewCode.SHUTDOWN_APPLICATION.isShutdownApplication()).isEqualTo(true);
	}
}
