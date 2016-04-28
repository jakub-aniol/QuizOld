package settings;

import javax.persistence.*;

/**
 * Created by jakub on 18.04.16.
 */
@Entity
@Table(name = "Pytania")
public class Answer implements Comparable<Answer> {
    @Id
    @GeneratedValue
    int ID;
    @Column(name = "Odpowiedź")
    String answerName;
    @Column(name = "Kategoria")
    Category category;
    @Column(name = "Ilosc_punktow")
    int answerPoints;
    @Column(name = "ID_Odpowiedzi")
    int answerID;
    @Column(name = "Czy_wybrana")
    boolean isChoosen;
    @Column(name = "Czy_prawdziwa")
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
        strReturn += "  " +this.answerPoints+ "   "+this.isChoosen;
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
