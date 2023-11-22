package lotto_auto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MagicNumber {
    String magicNumber;
    public List<List<Integer>> lottoTotalNumberList;
    public static int threeMatches;
    public static int fourMatches;
    public static int fiveMatches;
    public static int sixMatches;

    public MagicNumber() {
    }

    public MagicNumber(String magicNumber, List<List<Integer>> lottoTotalNumberList) {
        this.magicNumber = magicNumber;
        this.lottoTotalNumberList = lottoTotalNumberList;
    }

    public void compareMagicNumber() {
        List<Integer> magicNumberList = separateMagicNumber();

        for (int j = 0; j < lottoTotalNumberList.size(); j++) {
            matchesCnt(getLottoMatches(j, magicNumberList, 0));
        }
    }

    private static void matchesCnt(int cnt) {
        if (cnt == 3) {
            threeMatches++;
        }
        if (cnt == 4) {
            fourMatches++;
        }
        if (cnt == 5) {
            fiveMatches++;
        }
        if (cnt == 6) {
            sixMatches++;
        }
    }

    private int getLottoMatches(int j, List<Integer> magicNumberList, int cnt) {
        for (int i = 0; i < 6; i++) {
            if (lottoTotalNumberList.get(j).contains(magicNumberList.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    private List<Integer> separateMagicNumber() {
        return Arrays.stream(magicNumber.split(", "))
                .map(Integer::new)
                .collect(Collectors.toList());
    }

}
