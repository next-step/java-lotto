package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.LottoNumber;
import lottosecond.domain.lottomaker.LottoNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<LottoNumber> makeLottoNumberList() {
        Scanner scanner = new Scanner(System.in);
        String lottoString = scanner.nextLine();

        return Arrays.stream(lottoString.split(","))
                .map(strNumber -> {
                    try {
                        return Integer.parseInt(strNumber.strip());
                    } catch (Exception e) {
                        throw new IllegalArgumentException("올바르지 않은 로또 번호 입력 형태입니다.");
                    }
                })
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
