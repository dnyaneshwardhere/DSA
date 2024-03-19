import java.util.Scanner;

public class Fractional_knapsack_greedy 
{
    static float capacity = 15;

    static void Profit_based(float profit[], float weight[], int n) 
    {    
         float total_profit = 0;
         float w = 0;
        float[] x = new float[n];

        for (int i = 0; i < n; i++) 
        {
            x[i] = 0;
        }

        // Sorting the array in descending order of profits
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (profit[i] < profit[j]) 
                {
                    float temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;

                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;
                }
            }
        }

        int i = 0;
        while (w < capacity && i < n) 
        {
            if (w + weight[i] <= capacity) 
            {
                x[i] = 1;
                w += weight[i];
            } 
            else 
            {
                float ratio = (capacity - w) / weight[i];
                x[i] = ratio;
                w += ratio * weight[i];
            }
            i++;
        }

        for (i = 0; i < n; i++) 
        {
            total_profit += profit[i] * x[i];
        }

        System.out.println("Final profit :" + total_profit);
    }

    static void Weight_based(float profit[], float weight[], int n) 
    {
        float total_profit = 0;

         float w = 0;

        float[] x = new float[n];
    
        for (int i = 0; i < n; i++) 
        {
            x[i] = 0;
        }
    
        // Sorting the array in ascending order of weights
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if (weight[i] > weight[j]) 
                {
                    float temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;
    
                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;
                }
            }
        }
    
        int i = 0;
        while (w < capacity) 
        {
            if (w + weight[i] <= capacity) 
            {
                x[i] = 1;
                w += weight[i];
            }
            else 
            {
                float ratio = (capacity - w) / weight[i];
                x[i] = ratio;
                w += ratio * weight[i];
            }
            i++;
        }
    
        for (i = 0; i < n; i++) 
        {
            total_profit += profit[i] * x[i];
        }
    
        System.out.println("Final profit :" + total_profit);
    }
    

    static void PIWI_based(float profit[], float weight[], int n) 
    {
         float total_profit = 0;

        float w = 0;

        float[] x = new float[n];

        for (int i = 0; i < n; i++) 
        {
            x[i] = 0;
        }

        // Sorting the arrays based on profit/weight ratio in descending order
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if ((profit[i] / weight[i]) < (profit[j] / weight[j])) 
                {
                    float temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;

                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;
                }
            }
        }

        int i = 0;
        while (w < capacity && i < n) 
        {
            if (w + weight[i] <= capacity) 
            {
                x[i] = 1;
                w += weight[i];
            }
            else 
            {
                float ratio = (capacity - w) / weight[i];
                x[i] = ratio;
                w += ratio * weight[i];
            }
            i++;
        }
        for (i = 0; i < n; i++) 
        {
            total_profit += profit[i] * x[i];
        }

        System.out.println("Final profit :" + total_profit);
    }


    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of Arrays : ");
        int n = sc.nextInt();

        float[] profit = new float[n];
        float[] weight = new float[n];

        System.out.println("Enter Profit array :");
        for (int i = 0; i < n; i++) 
        {
            profit[i] = sc.nextFloat();
        }

        System.out.println("Enter Weight array :");
        for (int j = 0; j < n; j++) 
        {
            weight[j] = sc.nextFloat();
        }

        System.out.println("\nProfit based method");
        Profit_based(profit, weight, n);

        System.out.println("\nWeight based method");
        Weight_based(profit, weight, n);

        System.out.println("\nPI/WI based method");
        PIWI_based(profit, weight, n);

        sc.close();
    }
}
