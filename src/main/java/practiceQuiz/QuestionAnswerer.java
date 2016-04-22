package practiceQuiz;

import settings.Answer;
import settings.Question;

import java.util.List;
import java.util.Scanner;

/**
 * Created by jakub on 20.04.16.
 * Is responsible for marking, indicatesd by User, Anwser as choosen.
 */
public class QuestionAnswerer {
    final int MIN_ANSWER = 1;
    final int MAX_ANSWER = 4;
    Scanner scanner = new Scanner(System.in);

    public int choseAnswer() {
        int n = 0;
        System.out.println("Twoja odpowiedź: ");

        String s = "";
        System.out.println("Podaj liczbe w przedziale "+MIN_ANSWER+" do "+MAX_ANSWER);
        do {
            try {
                s = scanner.next();
                n = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba całkowita: " + s);
            }
        } while (n < MIN_ANSWER || n > MAX_ANSWER);

        return n;
    }

    public void markChoosenAnswer(Question question, int answer) {
        List<Answer> answerList = question.getAnswerList();
        boolean checkd = true;
        int i = 1;
        for (Answer ans : answerList) {
            if (i == answer)
                ans.setChoosen(checkd);

            i++;
        }
    }


}
