package lotto.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 입력 값이 아닙니다. 다시 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String WINNING_LOTTO_NUMBERS_INPUT_FORM = "(4[0-5]|[1-3][0-9]|[1-9])(,(4[0-5]|[1-3][0-9]|[1-9])){5}";
    private static final String LOTTO_BONUS_NUMBER_INPUT_FORMAT = "^4[0-5]|[1-3][0-9]|[1-9]$";
    private static final String LOTTO_BONUS_NUMBER_INPUT_EXCEPTION_MESSAGE = "입력하신 보너스 번호는 이미 존재하는 당첨 번호 입니다. 다시 입력해주세요.";
    
    private final List<LottoNumber> winningLottoNumbersInput;
    private LottoNumber bonusNumber;
    
    public WinningLottoNumbers(String winningLottoNumbersInput) {
        this.winningLottoNumbersInput = checkWinningLottoNumbersInputFormatException(removeSpace(winningLottoNumbersInput));
    }
    
    private List<LottoNumber> checkWinningLottoNumbersInputFormatException(String winningLottoNumbersInput) {
        Matcher matcher = Pattern.compile(WINNING_LOTTO_NUMBERS_INPUT_FORM).matcher(winningLottoNumbersInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
        
        return getLottoNumbers(winningLottoNumbersInput);
    }
    
    private String removeSpace(String winningLottoNumbersInput) {
        return winningLottoNumbersInput.replace(SPACE, EMPTY);
    }
    
    private List<LottoNumber> getLottoNumbers(String winningLottoNumbersInput) {
        return Arrays.stream(winningLottoNumbersInput.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }
    
    public void inputBonusNumber(String bonusNumber) {
        this.bonusNumber = checkWinningLottoBonusNumberInputFormatException(bonusNumber);
    
        if (this.winningLottoNumbersInput.contains(this.bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_BONUS_NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    private LottoNumber checkWinningLottoBonusNumberInputFormatException(String bonusNumber) {
        Matcher matcher = Pattern.compile(LOTTO_BONUS_NUMBER_INPUT_FORMAT).matcher(bonusNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
        
        return new LottoNumber(Integer.parseInt(bonusNumber));
    }
    
    public int countMatchingNumber(List<LottoNumber> lottoTicket) {
        return (int) lottoTicket.stream()
                .filter(winningLottoNumbersInput::contains)
                .count();
    }
    
    public boolean isExistBonusLottoNumber(List<LottoNumber> lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}
