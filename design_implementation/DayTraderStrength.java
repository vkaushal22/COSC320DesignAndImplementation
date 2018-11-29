package design_implementation;
import java.util.Arrays;

public class DayTraderStrength {
	int algorithmAforStrength(int[] profits){

		int max = 0;
		int sum = 0;
		int n = profits.length;
		for(int i = 0; i < n; i++) {
		    for(int j = i; j <n; j++){
		       sum = 0; 
		        for(int k = i; k <=j; k++) {
		            sum = sum + profits[k];        
		            		if(max < sum) {
		            			max = sum;
		            		}
		        }
		    }
		}
		return max;
		}
	
    public int algorithmBforStrength(int [] profits){
        int [] ar = new int[profits.length+1];
        ar[0] = 0;

        for (int i = 1; i < ar.length ; i++) {
        		int prev = (ar[i-1]+profits[i-1]);
        		if(prev > profits[i-1]) {
        			ar[i] = prev;
        		}else {
        			ar[i] = profits[i-1];
        		}
        }

        int max = 0;
        for (int x = 1; x <ar.length ; x++) {
            if(ar[x] > max)
                max = ar[x];
        }

        return max;
    }

    public static void main(String[] args) {
        int profits[] = new int[3000];
    		
    		for(int i = 0; i < profits.length ; i++) {
    		 profits[i] = (int) (-10 + Math.random()*20);
    		}
    		DayTraderStrength i = new DayTraderStrength();
        System.out.println("dynamic  " + i.algorithmBforStrength(profits));
        System.out.println("brute  " + i.algorithmAforStrength(profits));

    }
}
