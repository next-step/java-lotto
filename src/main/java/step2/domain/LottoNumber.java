package step2.domain;

import step2.util.StringUtil;

import java.util.stream.IntStream;

public class LottoNumber {

    private final String lastWeekNumber;

    public LottoNumber(String lastWeekNumber) {
        this.lastWeekNumber = lastWeekNumber;
        lottoNumberSizeValidate();
    }

    public static LottoNumber of(String lastWeekNumber) {
        return new LottoNumber(lastWeekNumber);
    }
    public String getLastWeekNumber() {
        return this.lastWeekNumber;
    }

    private void lottoNumberSizeValidate() {
        if (StringUtil.isEmpty(this.lastWeekNumber)) {
            throw new IllegalArgumentException("지난 로또 번호를 입력해 주세요.");
        }

        String[] lottoNumbers = this.lastWeekNumber.split(",");
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException("로또 번호는 6보다 작거나 클 수 없습니다.");
        }

        IntStream.range(0, lottoNumbers.length)
                .filter(i -> Integer.parseInt(lottoNumbers[i]) > 45)
                .forEach(i -> {
                    throw new IllegalArgumentException("로또 번호는 1 ~ 45사이의 숫자여야 합니다.");
                });
    }

}
