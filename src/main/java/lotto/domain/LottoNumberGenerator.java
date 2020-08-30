package lotto.domain;

import lotto.utils.LottoValidationUtils;
import lotto.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.utils.CommonConstant.*;

public class LottoNumberGenerator {

    private static final String INPUT_WINNING_NUMBER_DELIMITER = ", |,";

    private static final List<Integer> LOTTO_TARGET_NUMBERS = IntStream.range(NUMBER_ONE, NUMBER_FORTY_SIX)
            .boxed()
            .distinct()
            .sorted()
            .collect(Collectors.toList());

    public static LottoTicket generateAutoLottoTicket() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_TARGET_NUMBERS);
        LottoValidationUtils.validateLottoNumberSizeToFortyFive(lottoNumbers);
        Collections.shuffle(lottoNumbers);

        return new LottoTicket(lottoNumbers.stream()
                .distinct()
                .limit(NUMBER_SIX)
                .sorted()
                .collect(Collectors.toList()));
    }

    public static List<LottoTicket> generateAutoLottoTickets(int quantity) {
        return Stream.generate(LottoNumberGenerator::generateAutoLottoTicket)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    public static LottoTicket generateManualLottoTicket(String manualLottoNumber) {
        String[] manualLottoNumbers = StringUtils.split(manualLottoNumber, INPUT_WINNING_NUMBER_DELIMITER);
        return new LottoTicket(Arrays.stream(manualLottoNumbers)
                .map(StringUtils::toInt)
                .limit(NUMBER_SIX)
                .sorted()
                .collect(Collectors.toList()));
    }

    public static List<LottoTicket> generateManualLottoTickets(List<String> manutalLottoNumber, int quantity) {
        return manutalLottoNumber.stream()
                .map(LottoNumberGenerator::generateManualLottoTicket)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    public static LottoTicket generateWinningNumber(String winningNumber) {
        String[] winningNumbers = StringUtils.split(winningNumber, INPUT_WINNING_NUMBER_DELIMITER);
        return new LottoTicket(Arrays.stream(winningNumbers)
                .map(StringUtils::toInt)
                .limit(NUMBER_SIX)
                .sorted()
                .collect(Collectors.toList()));
    }

}
