package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoiTest {

	@Test
	public void crop() {
		Roi roi = new Roi(3.1225);

		assertThat(roi.crop(2)).isEqualTo(3.12);
	}
}