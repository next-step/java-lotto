package lottogame.validator;

import lottogame.util.StringUtils;

import java.util.Optional;

public class InputLineValidator implements Validatable<String> {

    @Override
    public boolean isValid(String target) {
        return Optional.ofNullable(target)
                        .map(StringUtils::removeWhitespace)
                        .filter(StringUtils::isNotEmpty)
                        .isPresent();
    }

    @Override
    public String getInvalidMessage() {
        return "잘못된 입력값입니다.";
    }
}