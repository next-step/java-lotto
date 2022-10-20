package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step1.view.InputViewImpl;

public class InputTest {

	@Test
	void inputTest(){
		InputViewImpl inputView = new InputViewImpl();
		inputView.getOperation();
		Assertions.assertThatThrownBy(inputView::getOperation).isInstanceOf(IllegalArgumentException.class);
	}
}
