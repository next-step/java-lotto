package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Number implements Comparable<Number>{
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int LOTTO_NUMS = 6;
    private static Map<Integer, Number> number = new HashMap<>();
    private int num;

    static {
        IntStream.rangeClosed(START_NUM, END_NUM).forEach(i -> number.put(i, new Number(i)));
    }

    private Number(int number) {
        this.num = number;
    }

    public static Number of(String sDigit) {
        if(sDigit == null || sDigit.isEmpty()) {
            throw new RuntimeException("입력된 내용이 없습니다.");
        }
        return of(Integer.parseInt(sDigit));
    }

    public static Number of(int digit) {
        return Optional.ofNullable(number.get(digit))
                .orElseThrow(RuntimeException::new);
    }

    public int getNum() {
        return num;
    }

    public static Set<Number> initialNumber() {
        List<Number> initLotto = IntStream.rangeClosed(START_NUM, END_NUM)
                                .mapToObj(i -> number.get(i))
                                .collect(Collectors.toList());
        Collections.shuffle(initLotto);
        initLotto = initLotto.stream()
                    .limit(LOTTO_NUMS)
                    .collect(Collectors.toList()); //6개 짜르기
        return new HashSet<>(initLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public int compareTo(Number number) {
        return this.num - number.num;
    }
}
