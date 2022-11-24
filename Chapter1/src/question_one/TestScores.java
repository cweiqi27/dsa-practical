package question_one;

import java.util.*;

public class TestScores {
    private final List<Integer> scoreList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    private void mainMenu() {
        try {
            System.out.println("===========");
            System.out.println("Test Scores");
            System.out.println("===========");
            System.out.println("(1) Add score");
            System.out.println("(2) Display all score");
            System.out.println("(3) Display lowest score");
            System.out.println("(4) Display highest score");
            System.out.println("(5) Display average score");
            System.out.println("(6) Exit \n");

            System.out.println("Enter number 1-5 to choose an option: ");

            int choice = input.nextInt();

            switch(choice) {
                case 1 -> addScore();
                case 2 -> displayAllScore();
                case 3 -> displayLowestScore();
                case 4 -> displayHighestScore();
                case 5 -> displayAverageScore();
                case 6 -> System.exit(0);
                default -> {
                    System.out.println("Invalid input.\n");
                    mainMenu();
                }
            }
        } catch(Exception e) {
            System.out.println("Invalid Input.\n");
            continuePrompt();
        }
    }

    private void addScore() {
        System.out.println("Enter test score:");

        try {
            int testScore = input.nextInt();

            while(testScore < 0 || testScore > 100) {
                System.out.println("Test score out of bounds, please enter a number between 1 to 100: ");
                testScore = input.nextInt();
            }

            scoreList.add(testScore);
        } catch(NumberFormatException e) {
            System.out.println("Invalid number");
        }

        System.out.println("Test score added successfully. \n");

        continuePrompt();
    }

    private void displayAllScore() {
        if(scoreList.isEmpty()) isEmptyMessage();

        System.out.println("Test Scores:");

        for(int score : scoreList) {
            System.out.println(score);
        }

        continuePrompt();
    }

    private void displayLowestScore() {
        if(scoreList.isEmpty()) isEmptyMessage();

//        Using Collections.sort
        List<Integer> sortedScoreList = new ArrayList<>(scoreList);
        Collections.sort(sortedScoreList);
        int lowestScore = sortedScoreList.get(0);

        System.out.println("Lowest Score: " + lowestScore + "\n");

        continuePrompt();
    }

    private void displayHighestScore() {
        if(scoreList.isEmpty()) isEmptyMessage();

        List<Integer> sortedScoreList = new ArrayList<>(scoreList);
        Collections.sort(sortedScoreList);
        int highestScore = sortedScoreList.get(sortedScoreList.size() - 1);

        System.out.println("Highest Score: " + highestScore + "\n");

        continuePrompt();
    }

    private void displayAverageScore() {
        if(scoreList.isEmpty()) isEmptyMessage();

        int sum = 0;

        for(int score : scoreList) {
            sum += score;
        }

        int average = sum / scoreList.size();

        System.out.println("Average score: " + average + "\n");

        continuePrompt();
    }

    private void isEmptyMessage() {
        System.out.println("!!!");
        System.out.println("No score has been entered yet \n");

        continuePrompt();
    }

    private void continuePrompt() {
        System.out.println("***");
        System.out.println("Enter any value to continue: ");
        input.next();
        mainMenu();
    }

    public static void main(String[] args) {
        TestScores testScores = new TestScores();
        testScores.mainMenu();
    }

}
