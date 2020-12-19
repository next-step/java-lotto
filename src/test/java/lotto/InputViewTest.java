package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {

	@Test
	public void 지난주_당첨번호가_잘입력되었는가_테스트() {
		InputView inputView = new InputView();
		assertThat(inputView.convertStringToInteger("1, 2, 3, 4, 5, 6").lottoNumbers.size()).isEqualTo(6);

		assertThat(inputView.convertStringToInteger("1 , 2 , 3 , 4, 5, 6").lottoNumbers.size()).isEqualTo(6);

		assertThatIllegalArgumentException().isThrownBy(() -> {
			inputView.convertStringToInteger("1, 2, 3, 4, 5, 6, 7");
		});
		assertThatIllegalArgumentException().isThrownBy(() -> {
			inputView.convertStringToInteger("1, 1, 1, 1, 5");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			inputView.convertStringToInteger("A, 2, 3, 4, 5, 6, 7");
		});
	}
}
