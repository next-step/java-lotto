package lotto.util;

import lotto.domain.InputMoney;
import lotto.domain.Lotto;
import lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    private static final String SPLIT_REGEX = ",";

    public static List<Lotto> createAutoLottoList(Ticket ticket) {
        List<Lotto> lottoList = new ArrayList<>();
        LottoGenerator generator = new RandomLottoGenerator();
        for (int i = 0; i < ticket.getAutoCount(); i++) {
            lottoList.add(new Lotto(generator));
        }
        return lottoList;
    }

    public static Lotto createMenualLotto(List<Integer> numbers) {
        LottoGenerator generator = new ManualLottoGenerator(numbers);
        return new Lotto(generator);
    }

    public static List<Lotto> createMenualLottoList(List<Integer> numbers) {
        List<Lotto> lottoList = new ArrayList<>();
        LottoGenerator generator = new ManualLottoGenerator(numbers);
        lottoList.add(new Lotto(generator));
        return lottoList;
    }

    public static Lotto initTextToLotto(String lottoNumberText) {
        List<Integer> numberList = Arrays.stream(lottoNumberText.split(SPLIT_REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return LottoUtil.createMenualLotto(numberList);
    }
}
