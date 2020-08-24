package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static step1.Constant.NORMAL;

public class WinnersNo {
    private int bonusNumber;
    private List<Integer> winnersResultNos;

    public WinnersNo(int bonusNumber, String input) {
        this.bonusNumber = bonusNumber;
        this.winnersResultNos = getWinnersResultNo(input);
    }

    public static WinnersNo ofWinnersNo(int bonusNumber, String input) {
        if (validateBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 입력 값이 잘못입력되었습니다.");
        }
        if (validateFormula(input)) {
            throw new IllegalArgumentException("지난 당첨 입력 값이 잘못입력되었습니다.");
        }
        return new WinnersNo(bonusNumber, input);
    }

    static List<Integer> getWinnersResultNo(String input) {
        String removingSpacesWinnersNo = input.replaceAll(" ", "");
        return Arrays.stream(removingSpacesWinnersNo.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinnersResultNos() {
        return winnersResultNos;
    }

    static boolean validateBonusNumber(int input) {
        return input > 45;
    }

    static boolean validateFormula(String input) {
        return Objects.isNull(input)
                || input.trim().length() == 0
                || Pattern.compile(NORMAL).matcher(input).find();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
