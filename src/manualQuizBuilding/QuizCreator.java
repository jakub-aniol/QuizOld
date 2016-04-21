package manualQuizBuilding;

import settings.Quiz;
import fileQuizBuilding.QuizFileReader;

/**
 * Created by jakub on 19.04.16.
 */
public class QuizCreator {
    String quizName;

    public Quiz makeQuiz() {
        Quiz quiz = new Quiz(QuizFileReader.readFileforQuestion());
        quiz.setQuizName(decideQuizName());
        return quiz;
    }

    private String decideQuizName() {
        String quizName = "Moj pierszy Quiz";
        return quizName;
    }
}
