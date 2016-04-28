package manualQuizBuilding;

import entityFactory.DAO;
import fileQuizBuilding.QuizFileReader;
import settings.Question;
import settings.Quiz;

import java.util.List;

/**
 * Created by jakub on 19.04.16.
 */
public class QuizCreator {

    public Quiz makeQuiz() {
        Quiz quiz = new Quiz(QuizFileReader.readFileforQuestion());
        quiz.setQuizName(decideQuizName());
        return quiz;
    }

    public Quiz makeQuiz(List<Question> questionsList) {
        Quiz quiz = new Quiz(questionsList);
        quiz.setQuizName(decideQuizName());
        DAO.addingDbQuiz(quiz);
        return quiz;
    }

    private String decideQuizName() {
        String quizName = "Moj pierszy Quiz";
        return quizName;
    }


}
