import jdk.nashorn.internal.ir.LabelNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Enum {
    /*
    enum Season {
        SPRING, SUMMER, FALL, WINTER
    }
    public static void main(String[] args) {
        Season season = Season.SPRING;
        System.out.println(season);
    }
     */
    enum Language {
        JAVA("1995", "James Gosling"),
        PYTHON("1989", "Guido van Rossum"),
        C("1971", "Denis Ritchie"),
        PHP("1995", "Rasmus Lerdorf");

        private final String year;
        private final String creator;

        private Language(String year, String creator) {
            this.year = year;
            this.creator = creator;
        }

        public String getYear() {
            return year;
        }

        public String getCreator() {
            return creator;
        }
    }
    public static void main(String[] args) {
        Language language = Language.PHP;
        System.out.println(language.getYear());
        System.out.println(language.getCreator());
        System.out.println(language.name());
        System.out.println(language.ordinal()); // JAVA = 0, PYTHON = 1, ...
        System.out.println(language.compareTo(Language.PYTHON)); // 0 - 1 = -1 // 1 - 1 = 0 // 2 - 1 = 1 // 3 - 1 = 2
        System.out.println(language.equals(Language.JAVA)); //true
    }
}
