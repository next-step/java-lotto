package io.mwkwon.lotto.view;

import io.mwkwon.lotto.domain.*;
import io.mwkwon.lotto.interfaces.DataGenerator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoInputView implements DataGenerator {
    private static final String REQUEST_PAYMENT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "지난주 당첨 번호를 입력해주세요.";
    private static final String RETRY_MESSAGE = "\n다시 입력 해주세요.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "지난주 당첨 번호 입력값과 동일한 값이 입력되었습니다.";
    private static final String NULL_AND_EMPTY_ERROR_MESSAGE = "로또 구입 금액이 잘못 입력되었습니다.";
    private static final String LOTTO_NUMBERS_ERROR_MESSAGE = "숫자 ','만 입력 가능합니다.";
    private static final String REGEX = "[^0-9, ]";
    private static final String DELIMITER = ",";
    private static final String REQUEST_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String REQUEST_MANUAL_LOTTO_PURCHASE_QUANTITY_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String REQUEST_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public LottoPayment requestInputPayment() {
        LottoPayment lottoPayment;
        do {
            String value = this.requestInput(REQUEST_PAYMENT_MESSAGE);
            lottoPayment = this.createLottoPayment(value);
        } while (lottoPayment == null);
        return lottoPayment;
    }

    @Override
    public Lotto requestWinningLottoNumbers() {
        Lotto lotto;
        do {
            String strLottoNumbers = this.requestInput(REQUEST_WINNING_LOTTO_MESSAGE);
            lotto = this.createLotto(strLottoNumbers);
        } while (lotto == null);
        return lotto;
    }

    @Override
    public LottoNumber requestBonusBallNumber(Lotto winningLotto) {
        LottoNumber bonusLottoNumber;
        do {
            String strNumber = this.requestInput(REQUEST_BONUS_BALL_NUMBER_MESSAGE);
            bonusLottoNumber = this.createBonusLottoNumber(strNumber, winningLotto);
        } while (bonusLottoNumber == null);
        return bonusLottoNumber;
    }

    @Override
    public PurchaseQuantity requestManualLottoPurchaseQuantity(LottoPayment lottoPayment) {
        PurchaseQuantity lottoPurchaseQuantity;
        do {
            String quantity = this.requestInput(REQUEST_MANUAL_LOTTO_PURCHASE_QUANTITY_MESSAGE);
            lottoPurchaseQuantity = this.createLottoPurchaseQuantity(quantity, lottoPayment);
        } while (lottoPurchaseQuantity == null);
        return lottoPurchaseQuantity;
    }

    @Override
    public List<LottoNumbers> requestManualLottoNumbers(PurchaseQuantity purchaseQuantity) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        if (purchaseQuantity.isSame(0)) {
            return null;
        }
        System.out.println(REQUEST_MANUAL_LOTTO_NUMBERS);
        while (purchaseQuantity.isLessThan(lottoNumbers.size())) {
            String value = this.requestInput();
            LottoNumbers lottoNumber = this.createLottoNumbers(value, DELIMITER);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private LottoPayment createLottoPayment(String value) {
        try {
            this.checkNullAndEmpty(value);
            return LottoPayment.create(Integer.parseInt(value.trim()));
        } catch (Exception e) {
            System.out.println(NULL_AND_EMPTY_ERROR_MESSAGE + RETRY_MESSAGE);
            return null;
        }
    }

    private Lotto createLotto(String strLottoNumbers) {
        try {
            LottoNumbers lottoNumbers = this.createLottoNumbers(strLottoNumbers, DELIMITER);
            return lottoNumbers.createLotto();
        } catch (Exception e) {
            System.out.println(e.getMessage() + RETRY_MESSAGE);
            return null;
        }
    }

    private LottoNumbers createLottoNumbers(String strLottoNumbers, String delimiter) {
        try {
            this.checkNullAndEmpty(strLottoNumbers);
            this.checkValidNumberAndDelimiter(strLottoNumbers);
            String[] split = strLottoNumbers.split(delimiter);
            List<LottoNumber> lottoNumbers = Stream.of(split)
                    .map(strNumber -> LottoNumber.create(Integer.parseInt(strNumber.trim())))
                    .collect(Collectors.toList());
            return LottoNumbers.create(lottoNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage() + RETRY_MESSAGE);
            return null;
        }
    }

    private LottoNumber createBonusLottoNumber(String strNumber, Lotto winningLotto) {
        try {
            this.checkNullAndEmpty(strNumber);
            LottoNumber lottoNumber = LottoNumber.create(Integer.parseInt(strNumber.trim()));
            this.checkDuplicateLottoNumber(lottoNumber, winningLotto);
            return lottoNumber;
        } catch (Exception e) {
            System.out.println(e.getMessage() + RETRY_MESSAGE);
            return null;
        }
    }

    private void checkNullAndEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkValidNumberAndDelimiter(String strLottoNumbers) {
        Matcher matcher = Pattern.compile(REGEX).matcher(strLottoNumbers);
        if (matcher.find()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_ERROR_MESSAGE);
        }
    }



    private void checkDuplicateLottoNumber(LottoNumber lottoNumber, Lotto winningLotto) {
        if (winningLotto.isContains(lottoNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private PurchaseQuantity createLottoPurchaseQuantity(String quantity, LottoPayment lottoPayment) {
        try {
            this.checkNullAndEmpty(quantity);
            PurchaseQuantity purchaseQuantity = PurchaseQuantity.create(Integer.parseInt(quantity));
            purchaseQuantity.checkValidPossiblePurchaseQuantity(lottoPayment);
            return purchaseQuantity;
        } catch (Exception e) {
            System.out.println(e.getMessage() + RETRY_MESSAGE);
            return null;
        }
    }

    private String requestInput(String message) {
        System.out.println(message);
        return this.scanner.nextLine();
    }

    private String requestInput() {
        System.out.println();
        return this.scanner.nextLine();
    }
}
