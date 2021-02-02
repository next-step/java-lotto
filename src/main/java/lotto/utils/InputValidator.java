package lotto.utils;

import lotto.domain.LottoTicket;

public class InputValidator {
    public static void checkNumberValidation(String number){
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 데이터입니다.");
        }
    }

    public static void checkPriceValidation(int price) {
        if(price < LottoTicket.PRICE){
            throw new IllegalArgumentException("로또를 구매할 수 없는 가격입니다.");
        }
    }

    public static void checkLottoNumberValidation(int lottoNumber) {
        if(lottoNumber < LottoTicket.MIN_LOTTO_NUMBER || lottoNumber > LottoTicket.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다.");
        }
    }


    public static void checkLengthWinningNumbersValidation(int length) {
        if(length != LottoTicket.PICKED_NUMBERS_SIZE){
            throw new IllegalArgumentException("당첨 로또 번호의 개수가 옳지 않습니다.");
        }
    }


}
