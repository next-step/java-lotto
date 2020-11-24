package step4.domain;

import step4.util.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int LOTTO_LIMIT_NUMBER = 6;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String LOTTO_SPLIT_COMMA = ",";

    private String lastWeekNumber;
    private String bonusNumber;

    private LottoNumber(String lastWeekNumber, String bonusNumber) {
        this.lastWeekNumber = lastWeekNumber;
        this.bonusNumber = bonusNumber;
    }

    public static LottoNumber of(String lastWeekNumber, String bonusNumber) {
        validate(lastWeekNumber, bonusNumber);
        return new LottoNumber(lastWeekNumber, bonusNumber);
    }

    public String getLastWeekNumber() {
        return this.lastWeekNumber;
    }

    public String getBonusNumber() {
        return this.bonusNumber;
    }

    private static void isEmpty(String lastWeekNumber) {
        if (StringUtil.isEmpty(lastWeekNumber)) {
            throw new IllegalArgumentException("지난 로또 번호를 입력해 주세요.");
        }
    }

    private static void lottoNumberValidate(String lastWeekNumber) {
        String[] lottoNumbers = lastWeekNumber.split(LOTTO_SPLIT_COMMA);
        IntStream.range(0, lottoNumbers.length)
                .filter(i -> Integer.parseInt(lottoNumbers[i]) > LOTTO_MAX_NUMBER)
                .forEach(i -> {
                    throw new IllegalArgumentException("로또 번호는 1 ~ 45사이의 숫자여야 합니다.");
                });
    }

    private static void lottoNumberSizeValidate(String lastWeekNumber) {
        String[] lottoNumbers = lastWeekNumber.split(LOTTO_SPLIT_COMMA);
        if (lottoNumbers.length != LOTTO_LIMIT_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6보다 작거나 클 수 없습니다.");
        }
    }

    private static void bonusNumberValidate(String bonusNumber) {
        Pattern pattern = Pattern.compile("([0-9])");
        Matcher matcher = pattern.matcher(bonusNumber);

        if (!matcher.find()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void bonusNumberMaxValidate(String bonusNumber) {
        if (Integer.parseInt(bonusNumber) > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 볼 최대 숫자는 45입니다.");
        }
    }

    private static void validate(String lastWeekNumber, String bonusNumber) {
        isEmpty(lastWeekNumber);
        lottoNumberValidate(lastWeekNumber);
        lottoNumberSizeValidate(lastWeekNumber);
        bonusNumberValidate(bonusNumber);
        bonusNumberMaxValidate(bonusNumber);
    }
}
