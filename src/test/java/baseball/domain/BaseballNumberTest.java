package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumberTest {


    @ParameterizedTest
    @NullAndEmptySource
    void NULL_입력(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BaseballNumber(inputValue);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "%", "ab"})
    void 숫자_아닌_값_입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BaseballNumber("한글이다");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "45", "99"})
    void 범위_초과_입력(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BaseballNumber(inputValue);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "7", "3"})
    void 정상_숫자_입력(String inputValue) {
        assertThat(new BaseballNumber(inputValue).
                toIntegerBaseballNumber()).isEqualTo(Integer.parseInt(inputValue));
    }


}
