package settings;

import java.util.List;

import static java.util.Collections.max;

/**
 * Created by jakub on 18.04.16.
 */
public class Question {
    private String questionName;
    private Category category;
    private int eIDPytanie;
    private int maxPoints;
    private int numberOfAnswers;
    private boolean isMultiply;
    private List<Answer> answerList;

    public Question(String questionName, Category category, boolean isMultiply, int numberOfAnswers, List<Answer> answer) {
        this.questionName = questionName;
        this.category = category;
        this.isMultiply = isMultiply;
        this.numberOfAnswers = numberOfAnswers;
        this.answerList = answer;
    }

    public boolean isMultiply() {
        return isMultiply;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public String getQuestionName(){
        return this.questionName;
    }

    public void countingMaxPoints(List<Answer> answerList) {

        if (this.isMultiply() == true) {
            int max =0;
            for (Answer answer : answerList) {
            max += answer.getAnswerPoints();
                }
            this.maxPoints = max;

        }
        if (this.isMultiply() == false) {
            Answer najwieksza = max(answerList);
            this.maxPoints = najwieksza.getAnswerPoints();
        }
    }

    @Override
    public String toString() {
        String strReturn = "\n";
        strReturn += this.questionName + " " + this.maxPoints;

        strReturn += "\n";
        strReturn += this.answerList;
        return strReturn;
    }
}
