package step3.domain;

import step3.util.StringUtil;

import java.util.stream.IntStream;

public class LottoNumber {

    private static final int LOTTO_LIMIT_NUMBER = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String LOTTO_SPLIT_COMMA = ",";

    private String lastWeekNumber;
    private String bonusNumber;

    public LottoNumber(String lastWeekNumber, String bonusNumber) {
        this.lastWeekNumber = lastWeekNumber;
        this.bonusNumber = bonusNumber;
        isEmpty();
        lottoNumberValidate();
        lottoNumberSizeValidate();
    }

    public static LottoNumber of(String lastWeekNumber, String bonusNumber) {
        return new LottoNumber(lastWeekNumber, bonusNumber);
    }

    public String getLastWeekNumber() {
        return this.lastWeekNumber;
    }

    public String getBonusNumber() {
        return this.bonusNumber;
    }

    private void isEmpty() {
        if (StringUtil.isEmpty(this.lastWeekNumber)) {
            throw new IllegalArgumentException("지난 로또 번호를 입력해 주세요.");
        }
    }

    private void lottoNumberValidate() {
        String[] lottoNumbers = this.lastWeekNumber.split(LOTTO_SPLIT_COMMA);
        IntStream.range(0, lottoNumbers.length)
                .filter(i -> Integer.parseInt(lottoNumbers[i]) > LOTTO_MAX_NUMBER)
                .forEach(i -> {
                    throw new IllegalArgumentException("로또 번호는 1 ~ 45사이의 숫자여야 합니다.");
                });
    }

    private void lottoNumberSizeValidate() {
        String[] lottoNumbers = this.lastWeekNumber.split(LOTTO_SPLIT_COMMA);
        if (lottoNumbers.length != LOTTO_LIMIT_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6보다 작거나 클 수 없습니다.");
        }
    }
}
