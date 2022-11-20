package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManualNumberList implements NumberList {

    private static final Scanner sc3 = new Scanner(System.in);

    @Override
    public List<LottoNumber> makeNumberList() {
        String str = sc3.nextLine();
        return getLottoNumbers(str);
    }

    private static List<LottoNumber> getLottoNumbers(String str) {
        return Arrays.stream(str.split(", "))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
