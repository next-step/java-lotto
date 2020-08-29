package lotto.domain;

import lotto.utils.LottoValidationUtils;
import lotto.view.InputView;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    public static final int LOTTO_TICKET_PRICE = 1000;

    public int getLottoBuyCount(int price) {
        LottoValidationUtils.validateLottoTicketPrice(price, LOTTO_TICKET_PRICE);
        LottoValidationUtils.validateInputNegativeNumber(price);
        return price / LOTTO_TICKET_PRICE;
    }

    public int getAutoLottoBuyCount(int manualQuantity, int autoQuantity) {
        return autoQuantity - manualQuantity;
    }

    public List<String> setManualLottoNumbers(Scanner scanner, int manualLottoQuantity) {
        return IntStream.range(0, manualLottoQuantity)
                .mapToObj(i -> InputView.setManualLottoNumber(scanner))
                .collect(Collectors.toList());
    }
}
