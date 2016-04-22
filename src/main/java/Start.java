import settings.Quiz;
import manualQuizBuilding.QuizCreator;
import presentingQuiz.QuizPresenter;

/**
 * Created by jakub on 18.04.16.
 */
public class Start {
    public static void main(String[] args) {

        QuizCreator quizCreator = new QuizCreator();

        Quiz quiz = quizCreator.makeQuiz();

        QuizPresenter.showQuizToPractice(quiz);

        QuizPresenter.showQuizWithResults(quiz);





    }
}
