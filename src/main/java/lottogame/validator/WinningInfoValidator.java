package lottogame.validator;

import lottogame.domain.WinningInfo;

import java.util.Optional;

public class WinningInfoValidator implements Validatable<WinningInfo> {

    @Override
    public boolean isValid(WinningInfo target) {
        return Optional.ofNullable(target)
                .map(WinningInfo::getNumbers)
                .filter(numbers -> !numbers.contains(target.getBonusNumber()))
                .isPresent();
    }

    @Override
    public String getInvalidMessage() {
        return "보너스 번호는 당첨 번호에 없는 숫자로 선정 해 주세요.";
    }
}