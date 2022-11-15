package step4.model;


import step4.util.LottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {
	private final static String DELIMITER = ",";
	private final static String SPACE = " ";
	private final static String NON_SPACE = "";

	private final List<Lotto> lottoList = new ArrayList<>();

	public LottoList(final Money money, final LottoGenerator lottoGenerator, final List<String> manualLottos) {
		autoGenerate(money.getLottoTicketCnt() - manualLottos.size(), lottoGenerator);
		manualGenerate(manualLottos);
	}

	private void autoGenerate(final int ticketCnt, final LottoGenerator lottoGenerator) {
		IntStream.range(0, ticketCnt)
				.mapToObj(lotto -> new Lotto(lottoGenerator))
				.forEach(lottoList::add);
	}

	private void manualGenerate(final List<String> manualLottos){
		manualLottos.stream()
				.map(lottoString -> Arrays.stream(lottoString.replaceAll(SPACE, NON_SPACE).split(DELIMITER))
						.map(Integer::parseInt)
						.collect(Collectors.toList())
				)
				.forEach(lotto -> lottoList.add(new Lotto(lotto)));
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}
}
