package generate;

import java.util.List;

public interface LottoRandomNumberGenerator {

	/**
	 * 로또 랜덤 번호 생성
	 *
	 * @param length
	 * @return
	 */
	List<Integer> randomNumber (Integer length);
}
