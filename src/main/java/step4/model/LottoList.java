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
	private final List<String> manualLottos;
	private final int ticketCnt;
	private final LottoGenerator lottoGenerator;

	public LottoList(Money money, LottoGenerator lottoGenerator, List<String> manualLottos) {
		this.ticketCnt = money.getLottoTicketCnt();
		this.lottoGenerator = lottoGenerator;
		this.manualLottos = manualLottos;
		generate();
		addManualList();
	}
	private void generate() {
		IntStream.range(0, ticketCnt - manualLottos.size())
				.mapToObj(lotto -> new Lotto(lottoGenerator))
				.forEach(lottoList::add);
	}

	private void addManualList(){
		manualLottos.stream()
				.map(lottoString -> Arrays.stream(lottoString.replaceAll(SPACE, NON_SPACE).split(DELIMITER))
						.map(Integer::parseInt)
						.collect(Collectors.toList()))
				.forEach(lotto -> lottoList.add(new Lotto(lotto)));
	}

	public List<Lotto> getLottoList() {
		return lottoList;
	}
}
