package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final String BLANK = " ";
    private static final String DELETE_BLANK = "";
    private static final CachedLottoNumbers cachedLottoNumbers = new CachedLottoNumbers();

    public List<LottoNumbers> create(int amount) {
        if (amount == 0) {
            return new ArrayList<>();
        }
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        return getLottoNumbers(purchaseAmount.getLottoCount());
    }

    private List<LottoNumbers> getLottoNumbers(int lottoCount) {
        return cachedLottoNumbers.getLottoNumbers(lottoCount);
    }

    public LottoNumbers create(String numbers) {
        List<LottoNumber> lotto = splitString(numbers).stream()
                .map(Integer::parseInt)
                .map(cachedLottoNumbers::getLottoNumber)
                .collect(Collectors.toList());
        return new LottoNumbers(lotto);
    }

    private List<String> splitString(String value) {
        validEmpty(value);
        return Arrays.asList(value.replace(BLANK, DELETE_BLANK).split(DEFAULT_SEPARATOR));
    }

    private void validEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }

    public List<LottoNumbers> create(List<String> manualLotto) {
        List<LottoNumbers> result = new ArrayList<>();
        for (String lotto : manualLotto) {
            result.add(create(lotto));
        }
        return result;
    }
}
