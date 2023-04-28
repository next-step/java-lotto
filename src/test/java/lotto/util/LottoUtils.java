package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoUtils {

  public static LottoNumbers getLottoNumbers(int... numbers) {
    return new LottoNumbers(Arrays.stream(numbers)
                                  .boxed()
                                  .map(LottoNumber::new)
                                  .collect(Collectors.toList())
    );
  }

  public static LottoTickets getLottoTickets(LottoNumbers... lottoNumbers) {
    return new LottoTickets(Arrays.stream(lottoNumbers)
                                  .map(LottoTicket::new)
                                  .collect(Collectors.toList())
    );
  }
}
