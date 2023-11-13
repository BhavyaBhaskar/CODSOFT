import java.util.*;
public class Task1
{
    static int score = 0;
    public void Guess(int RandomNum)
    {
        Scanner scan = new Scanner(System.in);

        int chance = 5;
        System.out.println("Enter your Guess");
        while (chance > 1)
        {
            int guess;
            guess = scan.nextInt();
            if(guess == RandomNum)
            {
                System.out.println("Congratulation, Your Guess is Correct");
                score = score + chance * 10;
                return;
            }
            else
            {
                System.out.println("Try Again");
            }
            chance--;
        }
        System.out.println("Sorry, You are unable to guess in 5 chances");
    }
    public static void main(String[] agrs) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        Task1 obj = new Task1();

        String c;
        do {
            int RandomNum = random.nextInt(9) + 1;
            obj.Guess(RandomNum);

            System.out.println("Do you want to Play again");
            System.out.println("1)Yes\n2)No");
            c = scan.next();
        } while (Objects.equals(c, "Yes"));
        System.out.println("Your Score is "+score);
    }
}
