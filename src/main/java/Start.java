import entityFactory.DAO;
import manualQuizBuilding.QuestionCreator;
import manualQuizBuilding.QuizCreator;
import org.apache.log4j.Logger;
import presentingQuiz.QuizPresenter;
import settings.Question;
import settings.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jakub on 18.04.16.
 */
public class Start {
    final static Logger logger = Logger.getLogger("Nowy logger");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;

        System.out.println("Wybierz opcję");
        System.out.println("Wczytaj ankietę z pliku, wpisz 1");
        System.out.println("Wpisz ankietę w kreatorze, wpisz 2");

        i = scanner.nextInt();

        System.out.println(i);
        if(i==1){
            QuizCreator quizCreator = new QuizCreator();

            Quiz quiz = quizCreator.makeQuiz();
            logger.error("Utworzono z pliku: "+quiz.getQuizName());

            QuizPresenter.showQuizToPractice(quiz);

            QuizPresenter.showQuizWithResults(quiz);
        }

        else {

            DAO.openFactory();

            QuizCreator quizCreator = new QuizCreator();
            List<Question> questionsList = new ArrayList<>();

            Question question = QuestionCreator.creatigQuestion();

            questionsList.add(question);

            Quiz quiz = quizCreator.makeQuiz(questionsList);
            logger.info("Utworzono: " );

            QuizPresenter.showQuizToPractice(quiz);

            QuizPresenter.showQuizWithResults(quiz);
        }








    }
}
