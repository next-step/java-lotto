package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.ShuffleMakeStrategy;

public class LottoTest {

	@Test
	@DisplayName("로또 게임 생성 테스트 : 1~45 중 6개 생성")
	void gameMakeTest() {
		Lotto lotto = new Lotto(() -> {
			List<LottoNumber> gameNumberList = new ArrayList<>();
			gameNumberList.add(new LottoNumber(45));
			gameNumberList.add(new LottoNumber(5));
			gameNumberList.add(new LottoNumber(15));
			gameNumberList.add(new LottoNumber(31));
			gameNumberList.add(new LottoNumber(33));
			gameNumberList.add(new LottoNumber(25));
			return gameNumberList;
		});

		assertThat(lotto.getGameNumberList().get(0)).isEqualTo(new LottoNumber(5));
		assertThat(lotto.getGameNumberList().get(1)).isEqualTo(new LottoNumber(15));
		assertThat(lotto.getGameNumberList().get(2)).isEqualTo(new LottoNumber(25));
		assertThat(lotto.getGameNumberList().get(3)).isEqualTo(new LottoNumber(31));
		assertThat(lotto.getGameNumberList().get(4)).isEqualTo(new LottoNumber(33));
		assertThat(lotto.getGameNumberList().get(5)).isEqualTo(new LottoNumber(45));
	}

	@Test
	@DisplayName("로또 게임 생성 테스트 : 셔플을 통한 자동 생성")
	void gameMakeShuffleTest() {
		Lotto lotto = new Lotto(new ShuffleMakeStrategy());
		assertThat(lotto.getGameNumberList().size()).isEqualTo(6);
	}

	@Test
	@DisplayName("로또 게임 생성 테스트 : 6개가 아닌 숫자로 게임 생성")
	void gameMakeInvalidTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Lotto(() -> {
				List<LottoNumber> gameNumberList = new ArrayList<>();
				gameNumberList.add(new LottoNumber(45));
				gameNumberList.add(new LottoNumber(5));
				gameNumberList.add(new LottoNumber(15));
				return gameNumberList;
			});

			new Lotto(() -> {
				List<LottoNumber> gameNumberList = new ArrayList<>();
				gameNumberList.add(new LottoNumber(45));
				gameNumberList.add(new LottoNumber(5));
				gameNumberList.add(new LottoNumber(15));
				gameNumberList.add(new LottoNumber(1));
				gameNumberList.add(new LottoNumber(2));
				gameNumberList.add(new LottoNumber(3));
				gameNumberList.add(new LottoNumber(4));
				return gameNumberList;
			});
		});
	}

	@Test
	@DisplayName("로또 게임 생성 테스트 : 중복된 숫자로 6개 생성")
	void gameMakeInvalid2Test() {
		assertThatThrownBy(() -> {
			new Lotto(() -> {
				List<LottoNumber> gameNumberList = new ArrayList<>();
				gameNumberList.add(new LottoNumber(45));
				gameNumberList.add(new LottoNumber(5));
				gameNumberList.add(new LottoNumber(15));
				gameNumberList.add(new LottoNumber(15));
				gameNumberList.add(new LottoNumber(20));
				gameNumberList.add(new LottoNumber(33));
				return gameNumberList;
			});
		}).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복");
	}
}
