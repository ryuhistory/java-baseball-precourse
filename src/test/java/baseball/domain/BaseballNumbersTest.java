package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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


    @Test
    void 스트라이크_볼_정상_카운트() {
        Optional<Integer> randomAnyNumber = baseballRandomNumbers.getRandomNumberToList().stream().findAny();
        BaseballNumbers baseballNumbers = new BaseballNumbers(
                String.format("%d%d%d", randomAnyNumber.get(), randomAnyNumber.get(), randomAnyNumber.get()));

        assertEquals(baseballNumbers.getStrikeCount(baseballRandomNumbers), 1);
        assertEquals(baseballNumbers.getBallCount(baseballRandomNumbers), 2);

    }


}
