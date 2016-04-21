package settings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakub on 18.04.16.
 */
public class Quiz {
    String quizName;
    String quizDescription;
    String answerAfterPassing;
    int maxPoints;
    int pointsToPass;
    int collectedPoints;
    int numberOfQuestions;
    List<Question> qusetionsList = new ArrayList<>();

    public Quiz(List<Question> questionsList){
        this.qusetionsList = questionsList;
    }

    public String toString(){
        String strReturn = "";
        strReturn += this.quizName;
        strReturn += "\n";
        strReturn += this.qusetionsList;

        return strReturn;
    }

    public void setCollectedPoints(int n){
        this.collectedPoints = n;
    }

    public String getQuizName(){
        return this.quizName;
    }

    public void setQuizName(String quizName){
        this.quizName = quizName;
    }

    public List<Question> getQuestionList(){
        return this.qusetionsList;
    }



}
