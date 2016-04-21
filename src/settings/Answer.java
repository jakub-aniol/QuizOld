package settings;

/**
 * Created by jakub on 18.04.16.
 */
public class Answer implements Comparable<Answer> {
    String answerName;
    Category category;
    int answerPoints;
    int answerID;
    boolean isChoosen;
    boolean isProper;

    public Answer(String answerName, Category category, int answerPoints, boolean isProper) {
        this.answerName = answerName;
        this.category = category;
        this.answerPoints = answerPoints;
        this.isProper = isProper;
    }

    public int getAnswerPoints() {
        return this.answerPoints;
    }

    public boolean getIsProper() {
        return isProper;
    }

    public boolean isProper() {
        return isProper;
    }

    public void setChoosen(boolean choosen) {
        isChoosen = choosen;
    }

    public boolean getChoosen() {
        return this.isChoosen;
    }

    @Override
    public int compareTo(Answer o) {
        return this.answerPoints - o.answerPoints;
    }

    @Override
    public String toString() {
        String strReturn ="";
        strReturn += this.answerName;
        strReturn +="\n";

        return strReturn;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this.getClass()!=obj.getClass()) return false;
        if(this == obj)
            return true;
        Answer answer = (Answer)obj;
        if(this.category.equals(answer.category)
            && this.answerName.equals(answer.answerName))
            return true;
        return false;
    }
    @Override
    public int hashCode(){
        return this.category.hashCode()*this.answerName.hashCode()*this.answerID;
    }



}
