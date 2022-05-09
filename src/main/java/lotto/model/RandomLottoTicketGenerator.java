package lotto.model;

import lotto.util.RandomNumberGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomLottoTicketGenerator implements LottoTicketGenerator {
    @Override
    public LottoTicket generateNumberList() {
        Set<Integer> nums = RandomNumberGenerator.generateNumberSet(1, 45, 6);

        List<LottoNumber> lottoNumbers = nums.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}
