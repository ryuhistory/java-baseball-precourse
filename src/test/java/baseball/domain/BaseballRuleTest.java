package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballRuleTest {

    private BaseballRule baseballRule;

    @BeforeEach
    void setUp() {
        baseballRule = new BaseballRule();
    }

    @Test
    void 정상_스트라이크_카운트_생성() {
        assertThat(baseballRule.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void 정상_볼_카운트_생성() {
        assertThat(baseballRule.getBallCount()).isEqualTo(0);
    }

    @Test
    void 정상_스트라이크_추가_카운트() {
        baseballRule.addStrikeCount(1);
        assertEquals(baseballRule.getStrikeCount(), 1);
    }

    @Test
    void 정상_볼_추가_카운트() {
        baseballRule.addBallCount(1);
        assertEquals(baseballRule.getBallCount(), 1);
    }

    @Test
    void 정상_카운트_초기화() {
        baseballRule.addStrikeCount(3);
        baseballRule.initializeBaseballCount();
        assertEquals(baseballRule.getStrikeCount(), 0);
    }
}
