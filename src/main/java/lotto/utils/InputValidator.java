package lotto.utils;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private InputValidator() {}

    public static boolean validatePrice(String number) {
        try{
            checkNumberValidation(number);
            checkBuyPriceValidation(Integer.parseInt(number));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean validateWinningNumber(String winningNumbersInput) {
        try{
            List<String> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            checkLengthWinningNumbersValidation(winningNumbers.size());
            winningNumbers.forEach(InputValidator::checkLottoNumberValidation);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void checkNumberValidation(String number) throws IllegalArgumentException{
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 데이터입니다.");
        }
    }

    public static void checkBuyPriceValidation(int price) throws IllegalArgumentException{
        if(price < LottoTicket.PRICE){
            throw new IllegalArgumentException("로또를 구매할 수 없는 가격입니다.");
        }
    }

    public static void checkLottoNumberValidation(String number) throws IllegalArgumentException {
        checkNumberValidation(number);
        int lottoNumber = Integer.parseInt(number);
        if(lottoNumber < LottoNumber.MIN_LOTTO_NUMBER || lottoNumber > LottoNumber.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다.");
        }
    }


    public static void checkLengthWinningNumbersValidation(int length) {
        if(length != LottoTicket.PICKED_NUMBERS_SIZE){
            throw new IllegalArgumentException("당첨 로또 번호의 개수가 옳지 않습니다.");
        }
    }


}
