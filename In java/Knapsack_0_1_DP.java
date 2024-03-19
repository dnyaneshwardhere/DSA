import java.util.Scanner;
import java.util.Vector;

public class Knapsack_0_1_DP 
{
    static void Calc_Knapsack_table(int[] benefits, int[] weights, int n, int T_Weight)
    {
        int[][] c = new int[n + 1][T_Weight + 1];

        //for making 1st row 0
        for(int w=0; w<=T_Weight; w++)
        {
            c[0][w] = 0;
        }

        //for making 1st column 0
        for(int i=0; i<=n; i++)
        {
            c[i][0] = 0;
        }

        for(int i=1; i<=n; i++)
        {
            for(int w=1; w<=T_Weight; w++)
            {
                if(weights[i-1] <= w)
                {
                    c[i][w] = Math.max(benefits[i - 1] + c[i - 1][w - weights[i - 1]], c[i - 1][w]);
                }
                else
                {
                    c[i][w] = c[i-1][w];
                }
            }
        }

        // for Selecting items
        int i =n;
        int k = T_Weight;
        Vector<Integer> selected_benefit = new Vector<>();
        Vector<Integer> selected_weight = new Vector<>();

        while(i > 0 && k > 0)
        {
            if(c[i][k] != c[i-1][k])
            {
                selected_benefit.add(benefits[i-1]);
                selected_weight.add(weights[i-1]);

                k = k - weights[i-1];
                i = i-1;
            }
            else
            {
                i = i-1;
            }
        }

        System.out.println("Benefits in Knapsack :"+selected_benefit);
        System.out.println("Benefits in Knapsack :"+selected_weight);
    }

    
    public static void main (String a[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Total weight (Capacity) :");
        int T_Weight = sc.nextInt();

        System.out.println("Enter the number items :");
        int n = sc.nextInt();

        int[] benefits = new int[n];
        int[] weights = new int[n];

        System.out.println("Enter  the Benefit values : ");
        for(int i=0; i<n; i++)
        {
            benefits[i] = sc.nextInt();
        }

        System.out.println("Enter  the Weight values : ");
        for(int i=0; i<n; i++)
        {
            weights[i] = sc.nextInt();
        }

        Calc_Knapsack_table(benefits, weights, n, T_Weight);
        sc.close();
    }    
}
