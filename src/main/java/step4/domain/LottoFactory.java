package step4.domain;

import cmm.util.InputUtil;
import step2.util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final List<LottoNumber> ALL_LOTTO_NUMBER = IntStream.rangeClosed(LottoNumber.LOTTO_START_NUMBER_VALUE, LottoNumber.LOTTO_LAST_NUMBER_VALUE)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    public static List<Lotto> makeLottoAutoList(int autoQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < autoQuantity; i++) {
            lottoList.add(makeLottoRandom());
        }
        return lottoList;
    }

    public static List<Lotto> makeLottoManualList(int manualQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < manualQuantity; i++) {
            lottoList.add(makeLottoWithString(InputUtil.returnStringWithBlank()));
        }
        return lottoList;
    }

    public static List<Lotto> allLottoList(List makeLottoAutoList, List makeLottoManualList) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(makeLottoManualList);
        lottoList.addAll(makeLottoAutoList);
        return lottoList;
    }

    public static Lotto makeLottoRandom() {
        Collections.shuffle(ALL_LOTTO_NUMBER);
        List getRandomNumberList = new ArrayList<>();
        for (int i = 0; i < Lotto.LOTTO_NUMBER; i++) {
            getRandomNumberList.add(ALL_LOTTO_NUMBER.get(i));
        }
        return new Lotto(new HashSet<>(getRandomNumberList));
    }

    public static Lotto makeLottoWithString(String lottoNumbers) {
        Set<LottoNumber> lottoNumber = new HashSet<>();
        String[] lottoNumberArray = StringSplit.splitWithDelimiter(lottoNumbers);
        for (String numberValue : lottoNumberArray) {
            lottoNumber.add(new LottoNumber(StringUtil.stringToInt(numberValue)));
        }
        return new Lotto(lottoNumber);
    }
}
