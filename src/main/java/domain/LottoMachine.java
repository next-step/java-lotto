package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_INDEX_MIN = 0;
    public static final int LOTTO_INDEX_MAX = 6;
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE_MONEY_NOT_ENOUGH = "1000원 이상의 금액을 입력해야 합니다.";
    private static final List<LottoNumber> lottoNumbers;
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 볼은 당첨 번호들이랑 달라야 합니다.";

    static {
        lottoNumbers = IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoTicket generate() {
        lottoNumbersShuffle();
        List<LottoNumber> lottoNumbers = LottoMachine.lottoNumbers.subList(LOTTO_INDEX_MIN, LOTTO_INDEX_MAX);
        lottoNumbers.sort(LottoNumber::ascendingSort);
        return new LottoTicket(new ArrayList<>(lottoNumbers));
    }

    public LottoTickets generate(int price) {
        List<LottoTicket> lottoTickets = Stream.generate(this::generate)
                .limit(purchaseQuantity(price))
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    private void lottoNumbersShuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public int purchaseQuantity(int price) {
        if(price < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_NOT_ENOUGH);
        }
        return price/ONE_LOTTO_PRICE;
    }

    public LottoNumber bonusBall(int inputNumber, WinningNumber winningNumber) {
        LottoNumber lottoNumber = new LottoNumber(inputNumber);
        if(winningNumber.contains(lottoNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
        return lottoNumber;
    }
}
