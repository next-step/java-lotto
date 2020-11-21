package step03.domain;

import exception.OutOfLottoNumberRangeException;

public class LottoBall implements Comparable<LottoBall>{
    private static final int START = 1;
    private static final int END = 46;
    public static LottoBall[] lottoNumbers = new LottoBall[END];

    static {
        for (int i = START; i < END; i++)
            lottoNumbers[i] = new LottoBall(i);
    }

    private final int number;

    private LottoBall(int number) {
        this.number = number;
    }

    public static LottoBall valueOf(int number) {
        validate(number);
        return lottoNumbers[number];
    }

    private static void validate(int number) {
        if (number < START || number >= END) {
            throw new OutOfLottoNumberRangeException();
        }
    }

    @Override
    public int compareTo(LottoBall lottoBall) {
        return number - lottoBall.number;
    }
}
