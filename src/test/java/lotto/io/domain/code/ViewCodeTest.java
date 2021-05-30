package lotto.io.domain.code;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import lotto.io.view.BonusBallView;
import lotto.io.view.BuyCustomGameCountView;
import lotto.io.view.BuyCustomGameView;
import lotto.io.view.GameWinningConditionView;
import lotto.io.view.TicketBoxView;
import lotto.io.view.WinningStaticsView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ViewCodeTest {

	@DisplayName("view")
	@Test
	@Order(1)
	void view() {
		//given

		//when

		//then
		assertThat(ViewCode.TICKET_BOX.view() instanceof TicketBoxView).isTrue();
		assertThat(ViewCode.BUY_CUSTOM_GAME_COUNT.view() instanceof BuyCustomGameCountView).isTrue();
		assertThat(ViewCode.BUY_CUSTOM_GAME.view() instanceof BuyCustomGameView).isTrue();
		assertThat(ViewCode.GAME_WINNING_CONDITION.view() instanceof GameWinningConditionView).isTrue();
		assertThat(ViewCode.BONUS_BALL.view() instanceof BonusBallView).isTrue();
		assertThat(ViewCode.WINNING_STATICS.view() instanceof WinningStaticsView).isTrue();
		assertThat(ViewCode.SHUTDOWN_APPLICATION.view()).isEqualTo(null);
	}
}
