package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class BaseBallRandomNumbersTest {

    @Test
    void 난수_정상_생성() {
        assertThat(new BaseballRandomNumbers().getRandomNumberToList().size() == 3).isTrue();
    }
}
