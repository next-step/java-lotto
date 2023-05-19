package lotto.domain.lotto;

import lotto.domain.result.WinNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoCompany {

    private static final String SPLIT_DELIMITER = ",";
    private static final LottoCompany lottoCompany = new LottoCompany();

    private LottoCompany() {};

    public static LottoCompany getInstance() {
        return lottoCompany;
    }

    public WinNumber announce(String stringNumbers, String bonusWinNumber) {
        return new WinNumber(convertToLotto(stringNumbers), LottoNumber.of(bonusWinNumber));
    }

    public ManualLottoBundle makeManualBundle(List<String> answerStrings) {
        List<Lotto> lottoList = answerStrings.stream()
                .map(LottoCompany.getInstance()::convertToLotto)
                .collect(Collectors.toList());
        return new ManualLottoBundle(lottoList);
    }

    private Lotto convertToLotto(String stringNumbers) {
        if (stringNumbers == null) {
            throw new IllegalArgumentException("로또로 전환할 번호들을 입력하지 않으셨습니다.");
        }
        String[] splitedNumbers = splitNumbers(stringNumbers);
        return new Lotto(makeLottoNumber(splitedNumbers));
    }

    private String[] splitNumbers(String winnerNumbers) {
        return winnerNumbers.trim().split(SPLIT_DELIMITER);
    }

    private Set<LottoNumber> makeLottoNumber(String[] splitedNumbers) {
        return Stream.of(splitedNumbers)
                .map(string -> {
                    string = string.trim();
                    return LottoNumber.of(string);
                })
                .collect(Collectors.toSet());
    }
}
