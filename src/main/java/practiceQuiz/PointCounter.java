package practiceQuiz;

import settings.Answer;
import settings.Question;
import settings.Quiz;

/**
 * Created by ja on 20.04.16.
 */
public class PointCounter {

    public int countingPoints(Quiz quiz) {
        boolean choosen = true;
        int points = 0;
        for (Question que : quiz.getQuestionList()) {
            for (Answer ans : que.getAnswerList()) {
                if (ans.getChoosen() == choosen)
                    if (ans.getIsProper() == ans.getChoosen()) {
                        points += ans.getAnswerPoints();
                    }
            }
        }
        return points;
    }
}
