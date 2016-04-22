package settings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jakub on 21.04.16.
 */
public class AnswerTest {
    private Answer answer1;
    private Answer answer2;
    private Answer answer3;

    @BeforeMethod
    public void setUp(){
        Category slq = Category.SQL;
        Category javaCore1 = Category.JavaCore;
        Category javaCore2 = Category.JavaCore;
        String answerName1 = "Pytanie1";
        String answerName2 = "Pytanie2";
        String answerName3 = "Pytanie2";
        int answerPoints1 = 2;
        int answerPoints2 = 3;
        int answerPoints3 = 3;
        boolean isProper1 = true;
        boolean isProper2 = true;
        boolean isProper3 = true;


        answer1 = new Answer(answerName1,slq, answerPoints1, isProper1);
        answer2 = new Answer(answerName2, javaCore1, answerPoints2, isProper2);
        answer3 = new Answer(answerName2,javaCore1, answerPoints3, isProper3);
    }

    @DataProvider
    public Object [][] isAnswerEqual(){
        Category slq = Category.SQL;
        Category javaCore1 = Category.JavaCore;
        Category javaCore2 = Category.JavaCore;
        String answerName1 = "Pytanie1";
        String answerName2 = "Pytanie2";
        String answerName3 = "Pytanie2";
        int answerPoints1 = 2;
        int answerPoints2 = 3;
        int answerPoints3 = 3;
        boolean isProper1 = true;
        boolean isProper2 = true;
        boolean isProper3 = true;
        return new Answer[][]{{new Answer(answerName1,slq, answerPoints1, isProper1)},
                {new Answer(answerName2,slq, answerPoints2, isProper1)}, };
    }

    @Test (dataProvider = "isAnswerEqual")
    public void testsIsAnswersAreEqual(Answer answer){
        //given
        Category slq = Category.SQL;
        String answerName1 = "Pytanie1";
        int answerPoints1 = 2;
        boolean isProper1 = true;
        Answer answer2 = new Answer(answerName1,slq, answerPoints1, isProper1);

        //when
        boolean expected = true;
        boolean result = answer2.equals(answer);
        //then
        assertThat(result).isEqualTo(expected);
    }
}
