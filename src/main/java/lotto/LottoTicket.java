package lotto;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class LottoTicket extends ArrayList<LottoNumbers> {

	public static LottoTicket purchase(int numberOfTicket) {
		LottoTicket purchasedTicket = new LottoTicket();
		IntStream.range(0, numberOfTicket).forEach(amount -> purchasedTicket.add(GenerateLottoNumber.auto()));
		return purchasedTicket;
	}
}
