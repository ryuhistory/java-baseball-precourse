package baseball.domain;

public class BaseballRule {

    final int STRIKE_OUT_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    public BaseballRule() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void addStrikeCount(int inputStrikeCount) {
        strikeCount += inputStrikeCount;
    }

    public void addBallCount(int inputBallCount) {
        ballCount += inputBallCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean checkGameOver() {
        if (strikeCount >= STRIKE_OUT_COUNT) {
            return true;
        }
        return false;
    }

    public void initializeBaseballCount() {
        if (checkGameOver()) {
            strikeCount = 0;
            ballCount = 0;
        }

    }


}
