package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoPurchase {

	public static final int START_INCLUSIVE = 0;

	public static Lottos buyLottos(LottoPayment lottoPayment, String[] manualLottos) {
		return new Lottos(Stream.concat(purchaseManualLottos(manualLottos).stream(),
			purchaseAutoLottos(lottoPayment.getAutoLottoCount()).stream()).collect(Collectors.toList()));
	}

	private static List<Lotto> purchaseAutoLottos(int autoLottoCount) {
		return IntStream.range(START_INCLUSIVE, autoLottoCount)
			.mapToObj(i -> LottoMachine.createLottoNumbers())
			.collect(Collectors.toList());
	}

	private static List<Lotto> purchaseManualLottos(String[] manualLottos) {
		return Arrays.stream(manualLottos).map(Lotto::new).collect(Collectors.toList());
	}
}
