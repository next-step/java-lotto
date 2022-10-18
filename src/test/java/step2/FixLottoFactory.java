package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import step2.LottoFactory;

public class FixLottoFactory implements LottoFactory {

	public final static List<Integer> FIX_NUM_LIST = Arrays.asList(1,6,22,33,41,45);

	@Override
	public List<Integer> getLottoNum() {
		return FIX_NUM_LIST;
	}
}
