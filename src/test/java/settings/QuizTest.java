package settings;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jakub on 21.04.16.
 */

public class QuizTest {

    Answer answer1e = new Answer("Pytanie1", Category.SQL, 2, true);
    Answer answer2e = new Answer("Pytanie2", Category.SQL, 3, true);
    Answer answer3e = new Answer("Pytanie3", Category.SQL, 4, true);

    List<Answer> listAnswersT = new ArrayList<>();
    List<Answer> listAnswersF = new ArrayList<>();

    Question quest1 = new Question("Wielokrotne", Category.GIT, true, 2, listAnswersT);
    Question quest2 = new Question("Wielokrotne", Category.GIT, true, 2, listAnswersF);
    Question quest3 = new Question("Jednokrotne", Category.GIT, false, 2, listAnswersT);
    Question quest4 = new Question("Jednokrotne", Category.GIT, false, 2, listAnswersF);

    List<Question> listQuestions = new ArrayList<>();

    {
        listAnswersT.add(answer1e);
        listAnswersT.add(answer2e);
    }

    {
        listAnswersF.add(answer2e);
        listAnswersF.add(answer3e);
    }

    {
        listQuestions.add(quest1);
        listQuestions.add(quest2);
        listQuestions.add(quest3);
        listQuestions.add(quest4);
    }

    @BeforeTest
    public void setup() {
        answer1e.setChoosen(true);
        answer2e.setChoosen(true);
        answer3e.setChoosen(true);
    }

    @Test
    public void testsIfCountingMaxPointForQuizIsProper() {
        //given
        Quiz quiz = new Quiz(listQuestions);
        int expected = 19;

        //when
        int result = 0;

        quiz.countMaxPointForQuiz();
        result = quiz.getMaxPointsQuiz();
        System.out.println("exp: "+expected);
        System.out.println("res: "+result);

        //then
        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void testsIfGetherdPointForQuizIsProper() {
        //given
        Quiz quiz = new Quiz(listQuestions);
        int expected = 19;

        //when
        int result = 0;

        quiz.countingGainedPoints(quiz);
        result = quiz.getMaxPointsQuiz();
        System.out.println("exp: "+expected);
        System.out.println("res: "+result);

        //then
        assertThat(expected).isEqualTo(result);
    }

}
