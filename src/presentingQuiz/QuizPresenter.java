package presentingQuiz;

import practiceQuiz.PointCounter;
import settings.Question;
import settings.Quiz;
import practiceQuiz.QuestionAnswerer;

import java.util.List;

/**
 * Created by jakub on 20.04.16.
 */
public class QuizPresenter {


    public static void showQuiz(Quiz quiz){
        List<Question> quizQuestionList;
        quizQuestionList = quiz.getQuestionList();
        int i = 0;
        for(Question que : quizQuestionList){
            i++;
            System.out.println(""+i + ". " + QuestionPresenter.showQuestion(que));
        }
    }

    public static void showQuizToPractice(Quiz quiz){
        QuestionAnswerer questionAnswerer = new QuestionAnswerer();
        List<Question> quizQuestionList;
        quizQuestionList = quiz.getQuestionList();
        int i = 0;
        for(Question que : quizQuestionList){
            i++;
            System.out.println(""+i + ". " + QuestionPresenter.showQuestion(que));
            int n = questionAnswerer.choseAnswer();
            questionAnswerer.markChoosenAnswer(que, n);

        }
    }

    public static void showQuizWithResults(Quiz quiz){

        PointCounter pointCounter = new PointCounter();
        List<Question> quizQuestionList;
        quizQuestionList = quiz.getQuestionList();
        int points = 0;
        int i =0;
        for(Question que : quizQuestionList){
            i++;
            System.out.println(""+i + ". " + QuestionPresenter.showQuestion(que));
            points = pointCounter.countingPoints(quiz);
        }
        System.out.println("Zgromadzileś punktów: "+points);
    }
}
