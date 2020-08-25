package step2.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinnersNo {
    private int bonusNumber;
    private List<Integer> winnersResultNos;

    public WinnersNo(int bonusNumber, String input) {
        this.bonusNumber = bonusNumber;
        this.winnersResultNos = getWinnersResultNo(input);
    }

    public static WinnersNo ofWinnersNo(int bonusNumber, String input) {
        validateBonusNumber(bonusNumber);
        validateFormula(input);
        return new WinnersNo(bonusNumber, input);
    }

    static List<Integer> getWinnersResultNo(String input) {
        String removingSpacesWinnersNo = input.replaceAll(" ", "");
        return Arrays.stream(removingSpacesWinnersNo.split(","))
                     .map(WinnersNo::toInt)
                     .collect(Collectors.toList());
    }

    public List<Integer> getWinnersResultNos() {
        return winnersResultNos;
    }

    static void validateBonusNumber(int input) {
        if (!(input > 0 && input < 45)) {
            throw new IllegalArgumentException("보너스 입력 값이 잘못입력되었습니다.");
        }
    }

    static void validateFormula(String input) {
        if (Objects.isNull(input)
            || input.trim().length() == 0) {
            throw new IllegalArgumentException("지난 당첨 입력 값이 잘못입력되었습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    static int toInt(String inputNumbers) {
        if (!StringUtils.isNumeric(inputNumbers)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return Integer.parseInt(inputNumbers);
    }
}
