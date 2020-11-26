package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoTicket {
    public static final int PRICE = 1000;
    private static List<LottoNumber> lottoNumberList =
            IntStream
                    .range(1, 45)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());
    private LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generate();
    }

    public LottoTicket(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(
                lottoNumbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }

    private static LottoNumbers generate() {
        Collections.shuffle(lottoNumberList);
        List<LottoNumber> list = new ArrayList<>(lottoNumberList.subList(0, 6));
        Collections.sort(list);
        return new LottoNumbers(list);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public DrawResult draw(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        if (this.lottoNumbers == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL_WINNING_LOTTO_TICKET);
        }
        int matchNumberCount = this.lottoNumbers.computeMatchCount(winningLottoNumbers);
        boolean bonus = this.lottoNumbers.contains(bonusNumber);
        if (bonus) {
            matchNumberCount++;
        }
        return DrawResult.valueOf(bonus, matchNumberCount);
    }
}
