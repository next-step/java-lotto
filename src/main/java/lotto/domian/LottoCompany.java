package lotto.domian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoCompany {

    private static final String SPLIT_DELIMITER = ",";
    private static LottoCompany lottoCompany = new LottoCompany();

    private LottoCompany() {};

    public static LottoCompany getInstance() {
        return lottoCompany;
    }

    public WinNumber announce(String stringNumbers, String bonusWinNumber) {
        return new WinNumber(convertToLotto(stringNumbers), new LottoNumber(bonusWinNumber));
    }

    public ManualLottoBundle makeManualBundle(List<String> answerStrings) {
        List<Lotto> lottoList = answerStrings.stream()
                .map(LottoCompany.getInstance()::convertToLotto)
                .collect(Collectors.toList());
        return new ManualLottoBundle(lottoList);
    }

    public LottoBundle makeLottoBundle(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(makeRandomLotto());
        }
        return new LottoBundle(lottoList);
    }

    private Lotto convertToLotto(String stringNumbers) {
        if (stringNumbers == null) {
            throw new IllegalArgumentException("로또로 전환할 번호들을 입력하지 않으셨습니다.");
        }
        String[] splitedNumbers = splitNumbers(stringNumbers);
        return new Lotto(makeLottoNumber(splitedNumbers));
    }

    private List<Integer> makeLottoBox() {
        return IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    private Lotto makeRandomLotto() {
        List<Integer> lottoNumberBox = makeLottoBox();
        Collections.shuffle(lottoNumberBox);

        return new Lotto(makeLottoNumber(lottoNumberBox.subList(0, 6)));
    }

    private Set<LottoNumber> makeLottoNumber(List<Integer> numberList) {
        return numberList.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toSet());
    }

    private String[] splitNumbers(String winnerNumbers) {
        return winnerNumbers.trim().split(SPLIT_DELIMITER);
    }

    private Set<LottoNumber> makeLottoNumber(String[] splitedNumbers) {
        return Stream.of(splitedNumbers)
                .map(string -> {
                    string = string.trim();
                    return new LottoNumber(string);
                })
                .collect(Collectors.toSet());
    }
}
