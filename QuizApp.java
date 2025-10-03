import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer; // index of correct option (0-based)

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your answer: ");
        int answer = sc.nextInt();
        return (answer - 1 == correctAnswer);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?",
                new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 1));
        questions.add(new Question("Which language is used for Android development?",
                new String[]{"Python", "Java", "C#", "Swift"}, 1));
        questions.add(new Question("Who is known as the father of computers?",
                new String[]{"Charles Babbage", "Alan Turing", "Bill Gates", "Steve Jobs"}, 0));

        int score = 0;

        System.out.println("===== Welcome to the Quiz App =====");

        for (Question q : questions) {
            if (q.askQuestion(sc)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
            }
        }

        System.out.println("\n===== Quiz Over! =====");
        System.out.println("Your Score: " + score + " / " + questions.size());

        sc.close();
    }
}