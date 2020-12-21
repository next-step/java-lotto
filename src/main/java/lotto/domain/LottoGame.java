package lotto.domain;

import util.ValidateUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final String VALID_EMPTY_MESSAGE = "금액을 다시 입력해주세요";
    private static final String VALID_NUMBER_MESSAGE = "금액은 숫자만 입력해주세요.";
    private static final String VALID_PURCHASE_UNIT_MESSAGE = "로또 구매 단위는 1000원입니다.";
    private static final int MIN_PRICE = 1000;
    private static final int MOD_ZERO = 0;

    private List<Lotto> lottos = new ArrayList<>();
    private LottoNumberRepository lottoNumberRepository = new LottoNumberRepository();
    private int lottoCount;

    public LottoGame(String price) {
        validatePrice(price);
    }

    private void validatePrice(String price) {
        validateEmpty(price);
        validateNumber(price);
    }

    private void validateEmpty(String price) {
        if (ValidateUtils.isEmpty(price)) {
            throw new IllegalArgumentException(VALID_EMPTY_MESSAGE);
        }
    }

    private void validateNumber(String price) {
        try {
            int lottoPrice = Integer.parseInt(price);
            validatePurchasingUnit(lottoPrice);
            this.lottoCount = lottoPrice / MIN_PRICE;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NUMBER_MESSAGE);
        }
    }

    private void validatePurchasingUnit(int price) {
        if (isNotPurchasingUnit(price)) {
            throw new IllegalArgumentException(VALID_PURCHASE_UNIT_MESSAGE);
        }
    }

    private boolean isNotPurchasingUnit(int price) {
        return (price < MIN_PRICE) || (price % MIN_PRICE != MOD_ZERO);
    }

    public void start() {
        for (int i = 0; i < lottoCount; i++) {
            System.out.println("Test");
            lottos.add(new Lotto(lottoNumberRepository.getLottoNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
