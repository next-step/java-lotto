package lotto.input;

import lotto.Lotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleWriter {
    private static final Scanner sc = new Scanner(System.in);

    public static BigDecimal inputBigDecimal() {
        String s = sc.nextLine();
        return BigDecimal.valueOf(Long.valueOf(s));
    }

    public static List<Integer> inputIntegerList() {
        String s = sc.nextLine();
        List result = new ArrayList<>();

        for (String num : s.split(",")) {
            result.add(Integer.parseInt(num));
        }

        if (result.size() != Lotto.SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리입니다.");
        }

        return result;
    }



}
