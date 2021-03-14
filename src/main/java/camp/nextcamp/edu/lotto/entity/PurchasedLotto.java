package camp.nextcamp.edu.lotto.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchasedLotto {
	private final List<Lotto> lottos;
	private final int manualLottoCount;
	private final int automaticLottoCount;

	public PurchasedLotto(ManualLottoTicket manualLottoTicket, LottoTicket lottoTicket) {
		this.lottos = getManualLottos(manualLottoTicket.getManualInputs());
		this.lottos.addAll(getRandomLottos(lottoTicket));
		this.manualLottoCount = manualLottoTicket.getTicketCount();
		this.automaticLottoCount = lottoTicket.getTicketCount();
	}

	private List<Lotto> getRandomLottos(LottoTicket lottoTicket) {
		return IntStream.range(0, lottoTicket.getTicketCount())
			.mapToObj((i) -> LottoNumber.generateRandomNumber())
			.map(Lotto::new)
			.collect(Collectors.toList());
	}

	private List<Lotto> getManualLottos(List<LottoInput> inputs) {
		return inputs.stream()
			.map(LottoInput::getNumbers)
			.map(Lotto::new)
			.collect(Collectors.toList());
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public int getManualLottoCount() {
		return manualLottoCount;
	}

	public int getAutomaticLottoCount() {
		return automaticLottoCount;
	}
}
