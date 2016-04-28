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
    int maxPointsQuiz;
    int pointsToPass;
    int numberOfQuestions;
    List<Question> qusetionsList = new ArrayList<>();

    public Quiz(List<Question> questionsList) {
        this.qusetionsList = questionsList;
        countMaxPointForQuiz();
    }

    public void countMaxPointForQuiz(){
        int maxPoint = 0;
        for(Question que : this.getQuestionList()){
            que.countingMaxPoints();
            maxPoint+=que.getMaxPoints();
        }
        this.setMaxPointForQuiz(maxPoint);
    }

    public String toString() {
        String strReturn = "";
        strReturn += this.quizName;
        strReturn += "\n";
        strReturn += this.qusetionsList;
        return strReturn;
    }

    public int getMaxPointsQuiz() {
        return maxPointsQuiz;
    }

    public void setMaxPointForQuiz(int maxPointForQuiz) {
        this.maxPointsQuiz = maxPointForQuiz;
    }

    public String getQuizName() {
        return this.quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public List<Question> getQuestionList() {
        return this.qusetionsList;
    }

    public int countingGainedPoints(Quiz quiz) {
        boolean choosen = true;
        int getherPoints = 0;

        for(Question ques : quiz.getQuestionList())
        for (Answer ans : ques.getAnswerList()) {
            if (ans.getChoosen() == choosen) {
                if (ans.getIsProper() == ans.getIsProper()) {
                    getherPoints+= ans.getAnswerPoints();
                }
            }
        }
        return getherPoints;
    }


}
