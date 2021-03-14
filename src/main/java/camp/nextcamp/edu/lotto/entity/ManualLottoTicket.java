package camp.nextcamp.edu.lotto.entity;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextcamp.edu.lotto.exception.UserException;
import camp.nextcamp.edu.lotto.exception.UserExceptionMesssage;

public class ManualLottoTicket extends LottoTicket {
	private final List<LottoInput> manualInputs;

	public ManualLottoTicket(List<String> manualInputs, int totalCount) {
		super(manualInputs.size());
		validateTicketSize(totalCount);
		this.manualInputs = makeLottoInputs(manualInputs);
	}

	private void validateTicketSize(int totalCount) {
		if (super.getTicketCount() > totalCount) {
			throw new UserException(UserExceptionMesssage.ILLEGAL_MANUAL_LOTTO_COUNT);
		}
	}

	private List<LottoInput> makeLottoInputs(List<String> inputs) {
		return inputs.stream()
			.map(LottoInput::new)
			.collect(Collectors.toList());
	}

	public List<LottoInput> getManualInputs() {
		return manualInputs;
	}
}
