package manualQuizBuilding;

import settings.Answer;
import settings.Category;
import settings.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jakub on 18.04.16.
 */

public class QuestionCreator {
    private static Scanner scanner = new Scanner(System.in);

    public static Question creatigQuestion() {
        Scanner scanner = new Scanner(System.in);
        List<Answer> answerList = new ArrayList<Answer>();

        String questionName = decideQuestionName(scanner);

        int ansNumber = decideAnswersNumber(scanner);

        boolean multiply = decideMultipilty(ansNumber);

        String strCategory = asignToCategory();

        asignAnswers(answerList, ansNumber, strCategory);

        return new Question(questionName, Category.valueOf(strCategory), multiply, ansNumber, answerList);
    }

    private static void asignAnswers(List<Answer> answerList, int ansNumber, String strCategory) {
        System.out.println("Przypisuj odpowiedzi");
        for (int i = 0; i < ansNumber; i++) {
            answerList.add(AnswerCreator.creatingAnswer(Category.valueOf(strCategory)));
        }
    }

    private static String asignToCategory() {
        System.out.println("Wybierz kategorię");
        System.out.println(Arrays.toString(Category.values()));

        String strCategory;
        do {
            strCategory = scanner.nextLine().toString();

            for (Category a : Category.values())
                if (strCategory.equals(a)) ;
            break;
        } while (!strCategory.equals(Category.valueOf(strCategory).toString()));
        return strCategory;
    }

    private static boolean decideMultipilty(int ansNumber) {
        boolean wielokrotnie = true;
        if (ansNumber > 1)
            return wielokrotnie;
        return !wielokrotnie;
    }

    private static int decideAnswersNumber(Scanner scanner) {
        System.out.println("Podaj ilość odpowiedzi");
        int ansNumber;
        try {
            ansNumber = Integer.parseInt(scanner.nextLine());
            if (ansNumber > 5 && ansNumber < 1)
                throw new WrongAmountOfAnswersException("sa");

        } catch (NumberFormatException | WrongAmountOfAnswersException e) {
            e.printStackTrace();
            System.out.println("Nie podaleś właściwej wartosci dla ilości odpowiedzi, wstawiono 1");
            ansNumber = 1;
        }
        return ansNumber;
    }

    private static String decideQuestionName(Scanner scanner) {
        System.out.println("Podaj nazwę pytania");
        String questionName;
        questionName = scanner.nextLine();
        return questionName;
    }


}
