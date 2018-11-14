import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.IntPredicate;

import org.junit.Test;

public class OptionalTest {

    // Creating Optional Objects
    @Test
    public void empty일때_Optional_of_검증() {
        Optional<String> empty = Optional.empty();
        assertThat(empty.isPresent()).isFalse();
    }

    @Test
    public void notNull일때_Optional_of_검증() {
        Optional<String> opt = Optional.of("korkorna");
        assertThat(opt.toString()).isEqualTo("Optional[korkorna]");
    }

    @Test(expected = NullPointerException.class)
    public void null일때_Optional_검증() {
        Optional<String> opt = Optional.of(null);
    }

    @Test
    public void notNull일때_Optional_ofNullable_검증() {
        Optional<String> opt = Optional.ofNullable("korkorna");
        assertThat(opt.toString()).isEqualTo("Optional[korkorna]");
    }

    @Test
    public void null일때_Optional_ofNullable_검증() {
        Optional<String> opt = Optional.ofNullable(null);
        assertThat(opt.toString()).isEqualTo("Optional.empty");
    }

    // Checking Value With isPresent()
    @Test
    public void Optional일때_Optional_isPresent_검증() {
        Optional<String> opt = Optional.of("korkorna");
        assertThat(opt.isPresent()).isTrue();

        opt = Optional.ofNullable(null);
        assertThat(opt.isPresent()).isFalse();
    }

    @Test
    public void Optional일때_Optional_ifPresent_검증() {
        Optional<String> opt = Optional.of("korkorna");
        opt.ifPresent(name -> System.out.println(name.length()));
        /*
         * if (name != null) { System.out.println(name.length()); }
         */
    }

    @Test
    public void Optional_OrElse_검증() {
        String name = (String) Optional.ofNullable(null).orElse("korkorna");
        assertThat(name).isEqualTo("korkorna");
    }

    @Test
    public void Optional_OrElseGet_검증() {
        String name = (String) Optional.ofNullable(null).orElseGet(() -> "korkorna");
        assertThat(name).isEqualTo("korkorna");
    }

    @Test
    public void null일때_Optional_OrElseGetAndOptional_OrElse_차이_검증() {
        String text = null;

        System.out.println("Using orElseGet:");
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertThat(defaultText).isEqualTo("Default Value");

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertThat(defaultText).isEqualTo("Default Value");
    }

    @Test
    public void 값이있을떄_Optional_OrElseGetAndOptional_OrElse_차이_검증() {
        String text = "Text present";

        // orElseGet을 쓸때는 래핑된 값이 있으면 getMyDefault 매소드를 호출하지 않지
        System.out.println("Using orElseGet:");
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertThat(defaultText).isEqualTo("Text present");

        // orElse를 쓸때는 래핑된 값의 유무와 상관없이 기본 객체가 생성되어 getMyDefault를 호출한다.
        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertThat(defaultText).isEqualTo("Text present");
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    @Test(expected = IllegalArgumentException.class)
    public void orElseThrowThrow_검증() {
        String name = (String) Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new);
    }

    @Test
    public void Optional일때_Optional_get_검증() {
        Optional<String> opt = Optional.of("korkorna");
        assertThat(opt.get()).isEqualTo("korkorna");
    }

    @Test(expected = NoSuchElementException.class)
    public void nullOptional일때_Optional_get_검증() {
        Optional<String> opt = Optional.ofNullable(null);
        opt.get();
    }

    @Test
    public void optional_filter_검증() {
        int year = 2016;
        Optional<Integer> yearOpt = Optional.of(year);
        assertThat(yearOpt.filter(y -> y == 2016).isPresent()).isTrue();
        assertThat(yearOpt.filter(y -> y == 2017).isPresent()).isFalse();
    }

    @Test
    public void filter2_검증() {
        assertThat(priceIsInRangel(new Modem(10.0))).isTrue();
        assertThat(priceIsInRangel(new Modem(9.9))).isFalse();
        assertThat(priceIsInRangel(new Modem(null))).isFalse();
        assertThat(priceIsInRangel(new Modem(15.5))).isFalse();
        assertThat(priceIsInRangel(null)).isFalse();
    }

    private boolean priceIsInRangel(Modem modem) {
        return Optional.ofNullable(modem).map(Modem::getPrice).filter(p -> p >= 10).filter(p -> p <= 15).isPresent();

        /*
         * 가격 범위를 체크하지만 취약점인 modem 객체의 유무를 체크해야함. if (modem != null && modem.getPrice()
         * != null && (modem.getPrice() >= 10 && modem.getPrice() <= 15)) { isInRange =
         * true; }
         */
    }

    @Test
    public void optional일때_Optional_map_검증() {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOpt = Optional.ofNullable(companyNames);
        int size = listOpt.map(List::size).orElse(0);
        assertThat(size).isEqualTo(6);
    }

    @Test
    public void optional_mapAndFilter_검증() {
        String password = "password";
        Optional<String> opt = Optional.of(password);

        boolean isCorrect = opt.filter(pass -> pass.equals("password")).isPresent();
        assertThat(isCorrect).isTrue();

        opt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();
        assertThat(isCorrect).isTrue();
    }

    @Test
    public void optional_flataMap_검증() {
        Person person = new Person("korkorna", 18);
        Optional<Person> opt = Optional.of(person);

        // case1 flatMap 없이 
        Optional<Optional<String>> nameOptionalWrapper = opt.map(Person::getName);
        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");
        assertThat(name1).isEqualTo("korkorna");
        
        // case2 flatMap사용해서
        String name = opt
                .flatMap(Person::getName)
                .orElse("");
        assertThat(name).isEqualTo("korkorna");
    }
}

class Person {
    private String name;
    private int age;
    private String password;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String password) {
        super();
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }
}

class Modem {
    private Double price;

    public Modem(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
