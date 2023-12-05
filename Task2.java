//STUDENT GRADE CALCULATOR
import java.util.Scanner;
public class Task2
{
    public int[] InputMark(int marks[])
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Maths marks: ");
        marks[0] = scan.nextInt();
        System.out.print("Enter Physics marks: ");
        marks[1] = scan.nextInt();
        System.out.print("Enter Chemistry marks: ");
        marks[2] = scan.nextInt();
        System.out.print("Enter Biology marks: ");
        marks[3] = scan.nextInt();
        System.out.print("Enter English marks: ");
        marks[4] = scan.nextInt();
        
        return (marks);
    }
    public int CalcSum(int marks[])
    {
        int sum=0;
        for(int i:marks)
        {
            sum+=i;
        }
        return(sum);
    }
    public double CalcAvg(int sum)
    {
        double avg = (double)sum/5;
        return(avg);
    }
    public char CalcGrade(double avg)
    {
        if(avg >= 90 && avg < 100)
        {
            return ('A');
        }
        else if(avg >= 80 && avg < 90)
        {
            return ('B');
        }
        else if(avg >= 70 && avg < 80)
        {
            return ('C');
        }
        else if(avg >= 60 && avg < 70)
        {
            return ('D');
        }
        else if(avg >= 50 && avg < 60)
        {
            return ('E');
        }
        else if(avg >= 0 && avg < 50)
        {
            return ('F');
        }
        return ('X');
    }
    public void display(int sum, double avg, char grade)
    {
        System.out.println("Total Marks : "+sum);
        System.out.println("Average Percentage : "+avg);
        System.out.println("Grade : "+grade);
    }
    public static void main(String[] main)
    {
        Task2 obj = new Task2();
        int marks[] = new int[5];
        marks = obj.InputMark(marks);
        int sum = obj.CalcSum(marks);
        double average = obj.CalcAvg(sum);
        char Grade = obj.CalcGrade(average);
        obj.display(sum,average,Grade);
    }
}