package calculator;

class TextManipulator {

        private static final String EMPTY_TEXT_DELIMITER = " ";

        static String[] splitByEmptyText(String text) {
                return text.split(EMPTY_TEXT_DELIMITER);
        }

        static boolean isNumericText(String text) {
                return text.chars().allMatch(Character::isDigit);
        }
}
