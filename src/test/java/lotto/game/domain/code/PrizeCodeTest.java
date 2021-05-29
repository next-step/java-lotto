package lotto.game.domain.code;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PrizeCodeTest {

	@DisplayName("4-1-2-7-1.`is~()` : 등가성 비교")
	@Test
	@Order(1)
	void isEqualMethods() {
		//given

		//when

		//then
		//isWinner()
		assertThat(PrizeCode.WINNER.isWinner()).isEqualTo(true);
		assertThat(PrizeCode.SECOND_PLACE.isWinner()).isEqualTo(false);
		assertThat(PrizeCode.THIRD_PLACE.isWinner()).isEqualTo(false);
		assertThat(PrizeCode.FOURTH_PLACE.isWinner()).isEqualTo(false);
		assertThat(PrizeCode.FIFTH_PLACE.isWinner()).isEqualTo(false);
		assertThat(PrizeCode.NOTHING.isWinner()).isEqualTo(false);
		//isSecondPlace()
		assertThat(PrizeCode.WINNER.isSecondPlace()).isEqualTo(false);
		assertThat(PrizeCode.SECOND_PLACE.isSecondPlace()).isEqualTo(true);
		assertThat(PrizeCode.THIRD_PLACE.isSecondPlace()).isEqualTo(false);
		assertThat(PrizeCode.FOURTH_PLACE.isSecondPlace()).isEqualTo(false);
		assertThat(PrizeCode.FIFTH_PLACE.isSecondPlace()).isEqualTo(false);
		assertThat(PrizeCode.NOTHING.isSecondPlace()).isEqualTo(false);
		//isThirdPlace()
		assertThat(PrizeCode.WINNER.isThirdPlace()).isEqualTo(false);
		assertThat(PrizeCode.SECOND_PLACE.isThirdPlace()).isEqualTo(false);
		assertThat(PrizeCode.THIRD_PLACE.isThirdPlace()).isEqualTo(true);
		assertThat(PrizeCode.FOURTH_PLACE.isThirdPlace()).isEqualTo(false);
		assertThat(PrizeCode.FIFTH_PLACE.isThirdPlace()).isEqualTo(false);
		assertThat(PrizeCode.NOTHING.isThirdPlace()).isEqualTo(false);
		//isFourthPlace()
		assertThat(PrizeCode.WINNER.isFourthPlace()).isEqualTo(false);
		assertThat(PrizeCode.SECOND_PLACE.isFourthPlace()).isEqualTo(false);
		assertThat(PrizeCode.THIRD_PLACE.isFourthPlace()).isEqualTo(false);
		assertThat(PrizeCode.FOURTH_PLACE.isFourthPlace()).isEqualTo(true);
		assertThat(PrizeCode.FIFTH_PLACE.isFourthPlace()).isEqualTo(false);
		assertThat(PrizeCode.NOTHING.isFourthPlace()).isEqualTo(false);
		//isFifthPlace()
		assertThat(PrizeCode.WINNER.isFifthPlace()).isEqualTo(false);
		assertThat(PrizeCode.SECOND_PLACE.isFifthPlace()).isEqualTo(false);
		assertThat(PrizeCode.THIRD_PLACE.isFifthPlace()).isEqualTo(false);
		assertThat(PrizeCode.FOURTH_PLACE.isFifthPlace()).isEqualTo(false);
		assertThat(PrizeCode.FIFTH_PLACE.isFifthPlace()).isEqualTo(true);
		assertThat(PrizeCode.NOTHING.isFifthPlace()).isEqualTo(false);
		//isFifthPlace()
		assertThat(PrizeCode.WINNER.isNothing()).isEqualTo(false);
		assertThat(PrizeCode.SECOND_PLACE.isNothing()).isEqualTo(false);
		assertThat(PrizeCode.THIRD_PLACE.isNothing()).isEqualTo(false);
		assertThat(PrizeCode.FOURTH_PLACE.isNothing()).isEqualTo(false);
		assertThat(PrizeCode.FIFTH_PLACE.isNothing()).isEqualTo(false);
		assertThat(PrizeCode.NOTHING.isNothing()).isEqualTo(true);
	}

	@DisplayName("4-1-2-7-2.`findCode()` : 코드 값 구하기")
	@Test
	@Order(2)
	void findCode() {
		//given
		int containZero = 0;
		int containOne = 1;
		int containTwo = 2;
		int containThree = 3;
		int containFour = 4;
		int containFive = 5;
		int containSix = 6;

		//when

		//then
		assertThat(PrizeCode.findCode(containZero)).isEqualTo(PrizeCode.NOTHING);
		assertThat(PrizeCode.findCode(containZero, true)).isEqualTo(PrizeCode.NOTHING);
		assertThat(PrizeCode.findCode(containOne)).isEqualTo(PrizeCode.NOTHING);
		assertThat(PrizeCode.findCode(containOne, true)).isEqualTo(PrizeCode.NOTHING);
		assertThat(PrizeCode.findCode(containTwo)).isEqualTo(PrizeCode.NOTHING);
		assertThat(PrizeCode.findCode(containTwo, true)).isEqualTo(PrizeCode.NOTHING);
		assertThat(PrizeCode.findCode(containThree)).isEqualTo(PrizeCode.FIFTH_PLACE);
		assertThat(PrizeCode.findCode(containThree, true)).isEqualTo(PrizeCode.FIFTH_PLACE);
		assertThat(PrizeCode.findCode(containFour)).isEqualTo(PrizeCode.FOURTH_PLACE);
		assertThat(PrizeCode.findCode(containFour, true)).isEqualTo(PrizeCode.FOURTH_PLACE);
		assertThat(PrizeCode.findCode(containFive)).isEqualTo(PrizeCode.THIRD_PLACE);
		assertThat(PrizeCode.findCode(containFive, true)).isEqualTo(PrizeCode.SECOND_PLACE);
		assertThat(PrizeCode.findCode(containSix)).isEqualTo(PrizeCode.WINNER);
		assertThat(PrizeCode.findCode(containSix, true)).isEqualTo(PrizeCode.WINNER);
	}
}
