package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToLottoConvertor {

    public Lotto lottoConvert(String lottoString) {
        List<Integer> collect = Arrays.stream(lottoString.split(","))
                .map(strNumber -> {
                    try {
                        return Integer.parseInt(strNumber.strip());
                    } catch (Exception e) {
                        throw new IllegalArgumentException("올바르지 않은 로또 번호 입력 형태입니다.");
                    }
                })
                .collect(Collectors.toList());

        return new Lotto(collect);
    }

    public List<Lotto> lottoListConvert(List<String> stringNumberList) {
        return stringNumberList.stream().map(this::lottoConvert)
                .collect(Collectors.toList());
    }
}
