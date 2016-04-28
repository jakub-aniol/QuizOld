package settings;

import java.util.List;

import static java.util.Collections.max;

/**
 * Created by jakub on 18.04.16.
 */
public class Question {
    public int maxPoints;
    private String questionName;
    private Category category;
    private int eIDPytanie;
    private int numberOfAnswers;
    private boolean isMultiply;
    private int gainedPoints;
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

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getGainedPoints() {
        return gainedPoints;
    }

    public void setGainedPoints(int gainedPoints) {
        this.gainedPoints = gainedPoints;
    }

    public String getQuestionName() {
        return this.questionName;
    }


    /**
     * Created by jakub on 18.04.16.
     * For multiply question answer ads each answer points if those are established proper
     * For single question answer choose the answer with max points between others answers in question
     * and if it is established proper
     */
    public void countingMaxPoints() {
        int maxPoints = 0;
        boolean proper = true;

        if (this.isMultiply() == true) {

            for (Answer answer : this.answerList) {
                if (answer.getIsProper() == proper)
                    maxPoints += answer.getAnswerPoints();
            }
            this.maxPoints = maxPoints;
        } else {
            Answer answer = max(this.answerList);
            if (answer.getIsProper() == proper)
                this.maxPoints = answer.getAnswerPoints();
        }
    }

    public void countingGainedPoints() {
        int gainedPoints = 0;
        boolean proper = true;

        if (this.isMultiply() == true) {

            for (Answer answer : this.answerList) {
                if (answer.getIsProper() == proper && answer.getChoosen() ==proper)
                    gainedPoints += answer.getAnswerPoints();
            }
            this.setGainedPoints(gainedPoints);

        } else {
            Answer answer = max(this.answerList);
            if (answer.getIsProper() == proper && answer.getChoosen()==proper)
                gainedPoints = answer.getAnswerPoints();
            this.setGainedPoints(gainedPoints);
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
