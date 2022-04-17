package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumbersTest {

    private BaseballRandomNumbers baseballRandomNumbers;

    @BeforeEach
    void setUp() {
        baseballRandomNumbers = new BaseballRandomNumbers();
    }

    @ParameterizedTest
    @ValueSource(strings = {"4354", "7345", "3323"})
    void 길이_초과_입력(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BaseballNumbers(inputValue);
        });
    }


}
