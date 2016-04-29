package com.example.calculator;

import android.util.Log;

public class Calculate {

	private String string;
	
	public Calculate(String result) {
		
		double num_1 = 0, num_2 = 0, k = 1;
		int c = 0;
		double number[] = new double[100];
		
		for(int i=0; result.charAt(i)!='='; ){
			num_2 = 0;
			k = 1; 
			if(result.charAt(i)>47 && result.charAt(i)<58){
				num_1 = (result.charAt(i)-48) + num_1*10;
				i++; 
				if(result.charAt(i) == '.'){ 
					i++; 
					while(result.charAt(i)>47 && result.charAt(i)<58){ 
						k=k*0.1; 
						num_2 = (result.charAt(i)-48)*k + num_2;
						i++;
					 }
				} 
				number[c] = num_1 + num_2; 
			} 
			else{ 
				number[++c] = result.charAt(i); 
				i++;
				num_1 = 0;
				c++;
			}
		} 
		
		for(int h=0; number[h]!=0; h++)
			Log.d("wangbin", number[h]+" ");

		int t = c+1;
			for(int j=1; j<t; j++){ 
				if(number[j]=='*' || number[j]=='/'){
					if(number[j] == '*'){
						number[j-1] = number[j-1]*number[j+1];
					}
					else{ 
						number[j-1] = number[j-1]/number[j+1];
					}
					int y = j;
					int n = 0; 
					while(n < t-j-2){ 
						number[y] = number[y+2]; 
						 y++; 
						 n++; 
					}
					t = t-2;
					j--;
				} 
			}
			double sum = number[0]; 
			for(int m=1; m<t-1; m+=2){
				if(number[m] == '+'){
					sum = sum + number[m+1];
				}
				else if(number[m] == '-'){
					sum = sum - number[m+1];
				}
			}
			
			//对结果进行处理
			int s;
			if(sum%1 == 0){
				s = (new Double(sum)).intValue();
			}
			string = sum +"";
	}
	
	public String getResult(){
		
		return string;
	}

}
